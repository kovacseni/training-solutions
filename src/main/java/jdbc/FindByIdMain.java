package jdbc;

import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.*;

public class FindByIdMain {

    public static void main(String[] args) throws SQLException {

        MariaDbDataSource dataSource;

        try {
            dataSource = new MariaDbDataSource();
            dataSource.setUrl("jdbc:mariadb://localhost:3306/employees?useUnicode=true");
            dataSource.setUser("employees");
            dataSource.setPassword("employees");
        } catch (SQLException sqle) {
            throw new IllegalStateException("Wrong dataSource", sqle);
        }

        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("select emp_name from employees where id = 3")) {

            if (rs.next()) {
                System.out.println(rs.getString("emp_name"));
            } else {
                throw new IllegalArgumentException("No employee found");
            }
        } catch (SQLException sqle) {
            throw new IllegalStateException("Can not query.", sqle);
        }

        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("select emp_name from employees where id = ?")) {
            String id = "4";
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                System.out.println(rs.getString("emp_name"));
                rs.close();
            } else {
                rs.close();
                throw new IllegalArgumentException("No employee found.");
            }
        } catch (SQLException sqle) {
            throw new IllegalArgumentException("Can not query.", sqle);
        }
    }
}
