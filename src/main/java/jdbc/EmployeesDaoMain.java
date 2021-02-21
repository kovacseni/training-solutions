package jdbc;

import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;

public class EmployeesDaoMain {

    public static void main(String[] args) throws SQLException {

        MariaDbDataSource dataSource;

        try {
            dataSource = new MariaDbDataSource();
            dataSource.setUrl("jdbc:mariadb://localhost:3306/employees?useUnicode =true");
            dataSource.setUser("employees");
            dataSource.setPassword("employees");
        } catch (SQLException sqle) {
            throw new IllegalStateException("Wrong dataSource.", sqle);
        }

        EmployeesDao dao = new EmployeesDao(dataSource);
        dao.createEmployee("James Doe");
        System.out.println(dao.listEmployeeNames());
        System.out.println(dao.findEmployeeNameById(4L));
    }
}
