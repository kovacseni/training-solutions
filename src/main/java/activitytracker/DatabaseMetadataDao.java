package activitytracker;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseMetadataDao {

    private DataSource dataSource;

    public DatabaseMetadataDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<String> getColumnsForTable(String table) {
        List<String> columnNames = new ArrayList<>();
        try (Connection conn = dataSource.getConnection()) {
            DatabaseMetaData meta = conn.getMetaData();
            loadColumnNamesToList(meta, columnNames, table);
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot get metadata from database.", sqle);
        }
        return columnNames;
    }

    private void loadColumnNamesToList(DatabaseMetaData meta, List<String> columnNames, String table) throws SQLException {
        try (ResultSet rs = meta.getColumns(null, null, table, null)) {
            while (rs.next()) {
                columnNames.add(rs.getString(4));
            }
        }
    }
}
