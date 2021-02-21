package jdbc;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.*;

public class ImagesDao {

    private DataSource dataSource;

    public ImagesDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void saveImage(String filename, InputStream is) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("insert into images(filename, content) values (?, ?)")) {
            stmt.setString(1, filename);
            Blob blob = conn.createBlob();

            fillBlob(is, blob);

            stmt.setBlob(2, blob);
            stmt.executeUpdate();
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot insert image.", sqle);
        }
    }

    private void fillBlob(InputStream is, Blob blob) throws SQLException {
        try (OutputStream os = blob.setBinaryStream((1))) {
            is.transferTo(os);
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot write blob.", ioe);
        }
    }

    public InputStream getImageByName(String name) {
        try (Connection conn = dataSource.getConnection();
        PreparedStatement stmt = conn.prepareStatement("select content from images where filename = ?")) {
            stmt.setString(1, name);
            return readInputStreamFromStatement(stmt);
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot read image.", sqle);
        }
    }

    private InputStream readInputStreamFromStatement(PreparedStatement stmt) throws SQLException {
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                Blob blob = rs.getBlob("content");
                return blob.getBinaryStream();
            }
            throw new IllegalStateException("Not found");
        }
    }
}
