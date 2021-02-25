package activitytracker;

import org.mariadb.jdbc.MariaDbDataSource;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ActivityTrackerMain {

    public static void main(String[] args) {

        List<Activity> activities = new ArrayList<>();
        Activity activity1 = new Activity(LocalDateTime.of(2021, 2, 22, 15, 35), "futás a parkban", ActivityType.RUNNING);
        activities.add(activity1);
        Activity activity2 = new Activity(LocalDateTime.of(2020, 8, 10, 11, 12), "Egész héten Zemplén!!!", ActivityType.HIKING);
        activities.add(activity2);
        Activity activity3 = new Activity(LocalDateTime.of(2020, 10, 2, 8, 15), "egész napos bicótúra", ActivityType.BIKING);
        activities.add(activity3);
        Activity activity4 = new Activity(LocalDateTime.of(2021, 1, 22, 9, 46), "meccs az iskola tornatermében", ActivityType.BASKETBALL);
        activities.add(activity4);
        Activity activity5 = new Activity(LocalDateTime.of(2020, 12, 22, 7, 52), "kis kör a tó körül", ActivityType.RUNNING);
        activities.add(activity5);

        MariaDbDataSource dataSource;

        try {
            dataSource = new MariaDbDataSource();
            dataSource.setUrl("jdbc:mariadb://localhost:3306/activitytracker?useUnicode=true");
            dataSource.setUser("activitytracker");
            dataSource.setPassword("activitytracker");
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot connect to database.", sqle);
        }

        ActivityTrackerMain atm = new ActivityTrackerMain();
        atm.insertIntoTable(dataSource, activities);
        int id = 2;
        Activity activity;
        if (atm.selectActivityById(dataSource, id).isPresent()) {
            activity = atm.selectActivityById(dataSource, id).get();
        }
        List<Activity> recordsFromTable = atm.getRecordsFromTable(dataSource);
    }

    private void insertIntoTable(DataSource dataSource, List<Activity> activities) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("insert into activities(start_time, activity_desc, activity_type) values (?, ?, ?);")) {
            for (Activity a : activities) {
                stmt.setTimestamp(1, Timestamp.valueOf(a.getStartTime()));
                stmt.setString(2, a.getDesc());
                stmt.setString(3, a.getType().toString());
                stmt.executeUpdate();
            }
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot insert.", sqle);
        }
    }

    private Optional<Activity> selectActivityById(DataSource dataSource, int id) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("select * from activities where id = ?;")) {
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();
            return getResult(rs);

        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot query.", sqle);
        }
    }

    private Optional<Activity> getResult(ResultSet rs) throws SQLException {
        if (rs.next()) {
            int foundId = rs.getInt(1);
            LocalDateTime startTime = rs.getTimestamp(2).toLocalDateTime();
            String description = rs.getString(3);
            ActivityType type = ActivityType.valueOf(rs.getString(4));
            Activity activity = new Activity(foundId, startTime, description, type);
            rs.close();
            return Optional.of(activity);
        } else {
            rs.close();
            return Optional.empty();
        }
    }

    private List<Activity> getRecordsFromTable(DataSource dataSource) {
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("select * from activities;")) {

            return getRecords(rs);

        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot query.", sqle);
        }
    }

    private List<Activity> getRecords(ResultSet rs) throws SQLException {
        List<Activity> recordsFromTable = new ArrayList<>();
        while (rs.next()) {
            int foundId = rs.getInt(1);
            LocalDateTime startTime = rs.getTimestamp(2).toLocalDateTime();
            String description = rs.getString(3);
            ActivityType type = ActivityType.valueOf(rs.getString(4));
            recordsFromTable.add(new Activity(foundId, startTime, description, type));
        }
        return recordsFromTable;
    }
}