package jdbc;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EmployeesDaoTest {

    private EmployeesDao dao;

    @BeforeEach
    public void init() throws SQLException {
        MariaDbDataSource dataSource = new MariaDbDataSource();
        dataSource.setUrl("jdbc:mariadb://localhost:3306/employees2?useUnicode=true");
        dataSource.setUser("employees2user");
        dataSource.setPassword("employees2password");

        dao = new EmployeesDao(dataSource);

        Flyway fw = Flyway.configure().dataSource(dataSource).load();
        fw.clean();
        fw.migrate();
    }

    @Test
    public void testInsert() {
        dao.createEmployee("John Doe");
        dao.createEmployee("Jane Doe");
        dao.createEmployee("Jack Doe");

        List<String> expected = Arrays.asList("John Doe", "Jane Doe", "Jack Doe");
        Assertions.assertEquals(expected, dao.listEmployeeNames());
    }

    @Test
    public void testFindEmployeeNameById() {
        dao.createEmployee("John Doe");
        dao.createEmployee("Jane Doe");
        dao.createEmployee("Jack Doe");

        Assertions.assertEquals("Jane Doe", dao.findEmployeeNameById(2L));
    }

    @Test
    public void testGetUniqueId() {
        dao.createEmployee("John Doe");
        dao.createEmployee("Jane Doe");

        Assertions.assertEquals(3L, dao.getUniqueId("James Doe"));
    }

    @Test
    public void testCreateEmployees() {
        List<String> names = Arrays.asList("Jack Doe", "Jane Doe", "Joe Doe");
        dao.createEmployees(names);
        List<String> expected = Arrays.asList("Jack Doe", "Jane Doe", "Joe Doe");

        Assertions.assertEquals(expected, dao.listEmployeeNames());
    }

    @Test
    public void testCreateEmployeesRollback() {
        List<String> names = Arrays.asList("Jack Doe", "Jane Doe", "xJoe Doe");
        dao.createEmployees(names);
        List<String> expected = Collections.emptyList();

        Assertions.assertEquals(expected, dao.listEmployeeNames());
    }

    @Test
    public void testOddNames() {
        List<String> names = Arrays.asList("John Doe", "Jack Doe", "Jane Doe", "Joe Doe", "James Doe");
        dao.createEmployees(names);
        List<String> oddNames = dao.listOddEmployeeNames();
        List<String> expected = Arrays.asList("Jack Doe", "Jane Doe", "John Doe");

        Assertions.assertEquals(expected, oddNames);
    }

    @Test
    public void testModifyEmployeeNames() {
        List<String> names = Arrays.asList("John Doe", "Jack Doe", "Jane Doe", "Joe Doe", "James Doe");
        dao.createEmployees(names);
        dao.modifyEmployeeNames();
        List<String> modifiedNames = dao.listEmployeeNames();
        List<String> expected = Arrays.asList("Mr. John Doe", "Mr. Jack Doe", "Jane Doe", "Mr. Joe Doe", "Mr. James Doe");

        Assertions.assertEquals(expected, modifiedNames);
    }
}
