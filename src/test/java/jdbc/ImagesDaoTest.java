package jdbc;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

public class ImagesDaoTest {

    private ImagesDao dao;

    @BeforeEach
    public void init() throws SQLException {
        MariaDbDataSource dataSource = new MariaDbDataSource();
        dataSource.setUrl("jdbc:mariadb://localhost:3306/employees2?useUnicode=true");
        dataSource.setUser("employees2user");
        dataSource.setPassword("employees2password");

        dao = new ImagesDao(dataSource);

        Flyway fw = Flyway.configure().dataSource(dataSource).load();
        fw.clean();
        fw.migrate();
    }

    @Test
    public void testSaveImage() throws IOException {
        dao.saveImage("training360", ImagesDaoTest.class.getResourceAsStream("/training360.png"));

        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        try (InputStream is = dao.getImageByName("training360")) {
            is.transferTo(baos);
        }

        Assertions.assertTrue(baos.size() > 2300);
    }
}
