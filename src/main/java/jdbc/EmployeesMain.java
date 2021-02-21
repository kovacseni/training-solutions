package jdbc;

import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeesMain {

    public static void main(String[] args) throws SQLException {
        MariaDbDataSource dataSource = new MariaDbDataSource();
        dataSource.setUrl("jdbc:mariadb://localhost:3306/employees?useUnicode=true");
        dataSource.setUser("employees");
        dataSource.setPassword("employees");

        Connection conn = dataSource.getConnection();

        Statement stmt1 = conn.createStatement();
        stmt1.executeUpdate("insert into employees(emp_name) values ('John Doe')");

        PreparedStatement stmt2 = conn.prepareStatement("insert into employees(emp_name) values (?)");
        stmt2.setString(1, "Jack Doe");
        stmt2.executeUpdate();
    }
}
