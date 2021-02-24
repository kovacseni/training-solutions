package activitytracker;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ActivityBefore {


    private DataSource dataSource;

    public ActivityBefore(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Activity> activitiesBeforeDate(LocalDate date) {
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("select * from activities;")) {

            return getActivitiesBeforeDateFromTable(rs, date);

        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot query.", sqle);
        }
    }

    private List<Activity> getActivitiesBeforeDateFromTable(ResultSet rs, LocalDate date) throws SQLException {

        List<Activity> activitiesFromTableBeforeDate = new ArrayList<>();

        while (rs.next()) {
            int id = rs.getInt(1);
            LocalDateTime startTime = rs.getTimestamp(2).toLocalDateTime();
            String description = rs.getString(3);
            ActivityType type = ActivityType.valueOf(rs.getString(4));
            if (startTime.toLocalDate().isBefore(date)) {
                activitiesFromTableBeforeDate.add(new Activity(id, startTime, description, type));
            }
        }

        return activitiesFromTableBeforeDate;
    }
}
