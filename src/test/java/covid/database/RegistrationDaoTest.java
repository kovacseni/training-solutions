package covid.database;

import covid.service.VaccinationState;
import covid.service.VaccineType;
import covid.service.Person;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.List;
import java.util.PriorityQueue;

public class RegistrationDaoTest {

    private RegistrationDao dao;
    private MariaDbDataSource dataSource;

    @BeforeEach
    public void setUp() throws SQLException {
        dataSource = new MariaDbDataSource();
        dataSource.setUrl("jdbc:mariadb://localhost:3306/covid?useUnicode=true");
        dataSource.setUser("coviduser");
        dataSource.setPassword("covidpassword");

        dao = new RegistrationDao();

        Flyway fw = Flyway.configure().locations("/db/migration/covid").dataSource(dataSource).load();
        fw.clean();
        fw.migrate();
    }

    @Test
    public void getTown() throws SQLException {
        Assertions.assertEquals("Baracska", dao.getTown("2471"));
        Assertions.assertEquals("Kiskunfélegyháza", dao.getTown("6100"));
    }

    @Test
    public void checkIfThisPersonIsRegistratedBefore() throws SQLException {
        Assertions.assertTrue(dao.checkIfThisPersonIsRegistratedBefore("181186249"));
        Assertions.assertFalse(dao.checkIfThisPersonIsRegistratedBefore("111111110"));
    }

    @Test
    public void writeIntoDatabase() throws SQLException {
        dao.writeIntoDatabase(new Person("Kiss József", "8671", 45, "a@b", "111111110"));
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("select * from citizens where taj = 111111110;")) {
            rs.next();
            Assertions.assertEquals(61, rs.getInt("citizen_id"));
            Assertions.assertEquals("Kiss József", rs.getString("citizen_name"));
            Assertions.assertEquals("8671", rs.getString("zip"));
            Assertions.assertEquals(45, rs.getInt("age"));
            Assertions.assertEquals("a@b", rs.getString("email"));
            Assertions.assertEquals(0, rs.getInt("number_of_vaccination"));
        }
    }

    @Test
    public void updateName() throws SQLException {
        dao.updateName("224459840", "Kiss József");
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("select citizen_id, citizen_name from citizens where taj = 224459840;")) {
            rs.next();
            Assertions.assertEquals(36, rs.getLong("citizen_id"));
            Assertions.assertEquals("Kiss József", rs.getString("citizen_name"));
        }
    }

    @Test
    public void updatePostalCode() throws SQLException {
        dao.updatePostalCode("224459840", "8671");
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("select citizen_id, zip from citizens where taj = 224459840;")) {
            rs.next();
            Assertions.assertEquals(36, rs.getLong("citizen_id"));
            Assertions.assertEquals("8671", rs.getString("zip"));
        }
    }

    @Test
    public void updateAge() throws SQLException {
        dao.updateAge("224459840", 149);
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("select citizen_id, age from citizens where taj = 224459840;")) {
            rs.next();
            Assertions.assertEquals(36, rs.getLong("citizen_id"));
            Assertions.assertEquals(149, rs.getInt("age"));
        }
    }

    @Test
    public void updateEmail() throws SQLException {
        dao.updateEmail("224459840", "a@b");
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("select citizen_id, email from citizens where taj = 224459840;")) {
            rs.next();
            Assertions.assertEquals(36, rs.getLong("citizen_id"));
            Assertions.assertEquals("a@b", rs.getString("email"));
        }
    }

    @Test
    public void deleteRegistration() throws SQLException {
        Assertions.assertTrue(dao.checkIfThisPersonIsRegistratedBefore("224459840"));
        dao.deleteRegistration("224459840");
        Assertions.assertFalse(dao.checkIfThisPersonIsRegistratedBefore("224459840"));
    }

    @Test
    public void getVaccinationList() throws SQLException {
        PriorityQueue<Person> vaccinationList = dao.getVaccinationList("2471");

        Assertions.assertEquals(21, vaccinationList.size());
    }

    @Test
    public void getPersonWithThisSsn() throws SQLException {
        Assertions.assertEquals("Pooh McVittie", dao.getPersonWithThisSsn("181186249").getName());
        Assertions.assertEquals(null, dao.getPersonWithThisSsn("222222220"));
    }

    @Test
    public void registrateVaccinationIntoDatabase() throws SQLException {
        dao.registrateVaccinationIntoDatabase("240417516", VaccinationState.ONE, LocalDate.of(2021, 3, 1), VaccineType.SINOPHARM);
        try (Connection conn = dataSource.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from citizens where citizen_name = 'Stephanus Pomery';")) {
            rs.next();
            Assertions.assertEquals("240417516", rs.getString("taj"));
            Assertions.assertEquals(1, rs.getInt("number_of_vaccination"));
            Assertions.assertEquals(LocalDate.of(2021, 3, 1), rs.getDate("last_vaccination").toLocalDate());
            Assertions.assertEquals("SINOPHARM", rs.getString("vaccine_type"));
        }

        try (Connection conn = dataSource.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from vaccinations where vaccination_id = 21;")) {
            rs.next();
            Assertions.assertEquals("240417516", rs.getString("taj"));
            Assertions.assertEquals(1, rs.getInt("number_of_vaccination"));
            Assertions.assertEquals(LocalDate.of(2021, 3, 1), rs.getDate("vaccination_date").toLocalDate());
            Assertions.assertEquals("SINOPHARM", rs.getString("vaccine_type"));
        }
    }

    @Test
    public void getTownData() throws SQLException {
        List<Integer> expected = dao.getTownData("2471");

        Assertions.assertEquals(21, expected.size());
        Assertions.assertEquals(0, expected.get(3));
        Assertions.assertEquals(1, expected.get(12));
    }

    @Test
    public void getPostalCodes() throws SQLException {
        List<String> expected = dao.getPostalCodes();

        Assertions.assertEquals(3485, expected.size());
    }
}