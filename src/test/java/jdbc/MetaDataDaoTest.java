package jdbc;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;
import java.util.List;

public class MetaDataDaoTest {

    private MetaDataDao dao;

    @BeforeEach
    public void init() throws SQLException {
        MariaDbDataSource dataSource = new MariaDbDataSource();
        dataSource.setUrl("jdbc:mariadb://localhost:3306/employees2?useUnicode=true");
        dataSource.setUser("employees2user");
        dataSource.setPassword("employees2password");

        dao = new MetaDataDao(dataSource);

        Flyway fw = Flyway.configure().locations("/db/migration/employees2").dataSource(dataSource).load();
        fw.clean();
        fw.migrate();
    }

    @Test
    public void testTableNames() {
        List<String> names = dao.getTableNames();

        Assertions.assertTrue(names.contains("employees2"));
    }
}
