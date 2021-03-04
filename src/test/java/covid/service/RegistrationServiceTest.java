package covid.service;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class RegistrationServiceTest {

    private RegistrationService service;
    private MariaDbDataSource dataSource;

    @BeforeEach
    public void setUp() throws SQLException {
        dataSource = new MariaDbDataSource();
        dataSource.setUrl("jdbc:mariadb://localhost:3306/covid?useUnicode=true");
        dataSource.setUser("coviduser");
        dataSource.setPassword("covidpassword");

        service = new RegistrationService();

        Flyway fw = Flyway.configure().locations("/db/migration/covid").dataSource(dataSource).load();
        fw.clean();
        fw.migrate();

        Install install = new Install();
        install.getPostalCodes(dataSource);
        install.getCitizens(dataSource);
        install.updateCitizens(dataSource);
        install.updateCitizensComments(dataSource);
        install.insertIntoVaccinations(dataSource);
        install.insertIntoVaccinationsComments(dataSource);
    }

    @Test
    public void postalCodeIsOKAndValid() throws SQLException {
        Assertions.assertTrue(service.postalCodeIsOKAndValid("2471"));
        Assertions.assertTrue(service.postalCodeIsOKAndValid("6100"));
        Assertions.assertFalse(service.postalCodeIsOKAndValid("123"));
        Assertions.assertFalse(service.postalCodeIsOKAndValid("1234"));
        Assertions.assertFalse(service.postalCodeIsOKAndValid("12345"));
        Assertions.assertFalse(service.postalCodeIsOKAndValid("12m3"));
    }

    @Test
    public void ageIsNumberAndIsOK() {
        Assertions.assertTrue(service.ageIsNumberAndIsOK("34"));
        Assertions.assertFalse(service.ageIsNumberAndIsOK("xyz"));
        Assertions.assertFalse(service.ageIsNumberAndIsOK("8"));
        Assertions.assertFalse(service.ageIsNumberAndIsOK("3m"));
        Assertions.assertFalse(service.ageIsNumberAndIsOK("208"));
    }

    @Test
    public void ssnIsOKAndNotRegistratedBefore() throws SQLException {
        Assertions.assertTrue(service.ssnIsOKAndNotRegistratedBefore("111111110"));
        Assertions.assertFalse(service.ssnIsOKAndNotRegistratedBefore("181186249"));
        Assertions.assertFalse(service.ssnIsOKAndNotRegistratedBefore("123"));
        Assertions.assertFalse(service.ssnIsOKAndNotRegistratedBefore("xyz"));
        Assertions.assertFalse(service.ssnIsOKAndNotRegistratedBefore("1811862491"));
        Assertions.assertFalse(service.ssnIsOKAndNotRegistratedBefore("181186m91"));
    }

    @Test
    public void registrateMass() throws IOException, SQLException {
        List<String> expected = service.registrateMass("citizens_hibas_tesztfile.csv", ";");

        Assertions.assertEquals(8, expected.size());
    }

    @Test
    public void generateVaccinationListByPostalCode() throws IOException, SQLException {
        service.generateVaccinationListByPostalCode(LocalDate.of(2021, 3, 2), "2471");
        List<String> expected = Files.readAllLines(Path.of("src/main/resources/covid/vaccinationlist_2021-03-02_2471.csv"));

        Assertions.assertEquals(4 + 16, expected.size());
    }

    @Test
    public void registrateFail() throws SQLException {
        service.registrateFail("988356050", "felborult az asztal", LocalDate.of(2021, 2, 25));
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("select comments from citizens where taj = 988356050;")) {
            rs.next();
            Assertions.assertEquals("Az oltás meghiúsult: 2021-02-02 Indok: terhesség; Az oltás meghiúsult: 2021-02-25 Indok: felborult az asztal", rs.getString(1));

        }

        try(Connection conn = dataSource.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from vaccinations where taj = 988356050")) {
            rs.next();
            Assertions.assertEquals(14, rs.getLong("vaccination_id"));
            Assertions.assertEquals("Az oltás meghiúsult. Indok: terhesség", rs.getString("comments"));
            rs.next();
            Assertions.assertEquals(21, rs.getLong("vaccination_id"));
            Assertions.assertEquals("Az oltás meghiúsult. Indok: felborult az asztal", rs.getString("comments"));
        }
    }

    @Test
    public void getTownStatistics() throws SQLException {
        Map<String, Integer> expected = service.getTownStatistics("2471");

        Assertions.assertEquals(20, expected.get("0_beoltatlan"));
        Assertions.assertEquals(1, expected.get("1 alkalommal beoltott"));
        Assertions.assertEquals(0, expected.get("2 alkalommal beoltott"));
    }

    @Test
    public void writeTownStatisticsToFile() throws IOException, SQLException {
        service.writeTownStatisticsToFile("2471");
        List<String> expected = Files.readAllLines(Path.of("src/main/resources/covid/townstatistics_" + LocalDate.now().toString() + "_2471.txt"));

        Assertions.assertEquals(1 + 3, expected.size());
    }

    @Test
    public void getHungaryStatistics() throws SQLException {
        Map<String, Map<String, Integer>> expected = service.getHungaryStatistics();

        Assertions.assertEquals(3485, expected.size());
    }

    @Test
    public void writeHungaryStatisticsToFile() throws IOException, SQLException {
        service.writeHungaryStatisticsToFile();
        List<String> expected = Files.readAllLines(Path.of("src/main/resources/covid/Hungarystatistics_" + LocalDate.now().toString() + ".txt"));

        Assertions.assertEquals(3 + 3485, expected.size());
    }
}