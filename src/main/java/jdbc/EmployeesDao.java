package jdbc;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeesDao {

    private DataSource dataSource;

    public EmployeesDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void createEmployee(String name) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("insert into employees2(emp_name) values (?)")) {
            stmt.setString(1, name);
            stmt.executeUpdate();
        } catch (SQLException sqle) {
            throw new IllegalStateException("Can not insert.", sqle);
        }
    }

    public List<String> listEmployeeNames() {
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("select emp_name from employees2")) {

            List<String> names = new ArrayList<>();
            while (rs.next()) {
                String name = rs.getString(1);
                names.add(name);
            }
            return names;
        } catch (SQLException sqle) {
            throw new IllegalStateException("Can not query.", sqle);
        }
    }

    public String findEmployeeNameById(long id) {
        try (Connection conn = dataSource.getConnection();
        PreparedStatement stmt = conn.prepareStatement("select emp_name from employees2 where id = ?")) {
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            String name = "No employee found.";
            if (rs.next()) {
                name = rs.getString("emp_name");
            }
            rs.close();
            return name;
        } catch (SQLException sqle) {
            throw new IllegalStateException("Can not query.", sqle);
        }
    }

    public long getUniqueId(String name) {
        try (Connection conn = dataSource.getConnection();
        PreparedStatement stmt = conn.prepareStatement("insert into employees2(emp_name) values (?)", Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, name);
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                long id = rs.getLong(1);
                rs.close();
                return id;
            }
            throw new IllegalStateException("Cannot get id.");
        } catch (SQLException sqle) {
            throw new IllegalStateException("Can not manage database.", sqle);
        }
    }

    public void createEmployees(List<String> names) {
        try (Connection conn = dataSource.getConnection()) {
            conn.setAutoCommit(false);

            try (PreparedStatement stmt = conn.prepareStatement("insert into employees2(emp_name) values (?)")) {
                for (String name : names) {
                    if (name.startsWith("x")) {
                        throw new IllegalArgumentException("Invalid name!");
                    }
                    stmt.setString(1, name);
                    stmt.executeUpdate();
                }
                conn.commit();
            } catch (IllegalArgumentException iae) {
                conn.rollback();
            }
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot insert", sqle);
        }
    }

    public List<String> listOddEmployeeNames() {
        try (Connection conn = dataSource.getConnection();
        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = stmt.executeQuery("select emp_name from employees2 order by emp_name")) {
            if (!rs.next()) {
                return Collections.emptyList();
            }
            List<String> names = new ArrayList<>();
            names.add(rs.getString("emp_name"));
            while (rs.relative(2)) {
                names.add(rs.getString("emp_name"));
            }
            return names;
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot list names", sqle);
        }
    }

    public void modifyEmployeeNames() {
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
             ResultSet rs = stmt.executeQuery("select id, emp_name from employees2")) {

            while (rs.next()) {
                String name = rs.getString("emp_name");
                if (!name.startsWith("Jane")) {
                    rs.updateString("emp_name", "Mr. " + name);
                    rs.updateRow();
                }
            }
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot modify names.", sqle);
        }
    }
}