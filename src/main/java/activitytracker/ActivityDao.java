package activitytracker;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ActivityDao {

    private DataSource dataSource;

    public ActivityDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void saveActivity(Activity activity) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("insert into activities(start_time, activity_desc, activity_type) values (?, ?, ?);")) {
            setStmt(activity, stmt);
            stmt.executeUpdate();
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot insert.", sqle);
        }
    }

    public void insertActivitiesFromList(List<Activity> activities) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("insert into activities(start_time, activity_desc, activity_type) values (?, ?, ?);")) {
            for (Activity a : activities) {
                setStmt(a, stmt);
                stmt.executeUpdate();
            }
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot insert values.", sqle);
        }
    }

    public Activity findActivityById(long id) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("select * from activities where id = ?;")) {
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            return returnActivityIfFound(rs);

        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot query.", sqle);
        }
    }

    private Activity returnActivityIfFound(ResultSet rs) throws SQLException {
        if (rs.next()) {
            int foundId = rs.getInt(1);
            LocalDateTime startTime = rs.getTimestamp(2).toLocalDateTime();
            String description = rs.getString(3);
            ActivityType type = ActivityType.valueOf(rs.getString(4));

            return new Activity(foundId, startTime, description, type);
        }
        throw new ActivityNotFoundException("Activity with this id not found.");
    }

    public List<Activity> listActivities() {
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("select * from activities;")) {

            return getActivitiesFromTable(rs);

        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot query.", sqle);
        }
    }

    private List<Activity> getActivitiesFromTable(ResultSet rs) throws SQLException {

        List<Activity> activitiesFromTable = new ArrayList<>();

        while (rs.next()) {
            int id = rs.getInt(1);
            LocalDateTime startTime = rs.getTimestamp(2).toLocalDateTime();
            String description = rs.getString(3);
            ActivityType type = ActivityType.valueOf(rs.getString(4));
            activitiesFromTable.add(new Activity(id, startTime, description, type));
        }

        return activitiesFromTable;
    }

    public Activity saveActivityAndReturnGeneratedKeys(Activity activity) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("insert into activities(start_time, activity_desc, activity_type) values (?, ?, ?);", Statement.RETURN_GENERATED_KEYS)) {

            setStmt(activity, stmt);
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                return new Activity(rs.getInt("id"), activity.getStartTime(), activity.getDesc(), activity.getType());
            }
            throw new IllegalStateException("Cannot get generated keys.");
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot insert.", sqle);
        }
    }

    public void saveActivityAndSaveTrackPoints(Activity activity) {
        try (Connection conn = dataSource.getConnection()) {
            conn.setAutoCommit(false);

            try {
                int activityId = saveActivitywithTrackPoints(activity, conn);
                saveTrackPoints(activityId, activity, conn);

                conn.commit();

            } catch (Exception ex) {
                conn.rollback();
                throw new IllegalArgumentException("Transaction not succeeded!");
            }

        } catch (SQLException sqle) {
            throw new IllegalStateException("Wrong connection.", sqle);
        }
    }

    private int saveActivitywithTrackPoints(Activity activity, Connection conn) throws Exception {
        int activityId = 0;
        try (PreparedStatement stmt = conn.prepareStatement("insert into activities(start_time, activity_desc, activity_type) values (?, ?, ?);", Statement.RETURN_GENERATED_KEYS)) {
            stmt.setTimestamp(1, Timestamp.valueOf(activity.getStartTime()));
            stmt.setString(2, activity.getDesc());
            stmt.setString(3, activity.getType().toString());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                activityId = rs.getInt(1);
            }
            return activityId;
        }
    }

    private void saveTrackPoints(int activityId, Activity activity, Connection conn) throws Exception {
        try (PreparedStatement stmt = conn.prepareStatement("insert into track_point(id, tp_time, lat, lon) values (?, ?, ?, ?);")) {
            for (TrackPoint t : activity.getTrackpoints()) {
                if (t.getLat() < -90.0 || t.getLat() > 90.0 || t.getLon() < -180 || t.getLon() > 180.0) {
                    throw new IllegalArgumentException();
                }
                stmt.setInt(1, activityId);
                stmt.setDate(2, Date.valueOf(t.getTime()));
                stmt.setDouble(3, t.getLat());
                stmt.setDouble(4, t.getLon());

                stmt.executeUpdate();
            }
        }
    }

    public Activity findActivityWithTrackPointsById(int id) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("select * from activities where id = ?;")) {
            stmt.setInt(1, id);
            return getActivityById(id, stmt, conn);
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot select activity or trackpoints.", sqle);
        }
    }

    private Activity getActivityById(int id, PreparedStatement stmt, Connection conn) throws SQLException {
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                LocalDateTime startTime = rs.getTimestamp(2).toLocalDateTime();
                String description = rs.getString(3);
                ActivityType type = ActivityType.valueOf(rs.getString(4));
                List<TrackPoint> trackPoints = getTrackPoints(id, conn);
                return new Activity(id, startTime, description, type, trackPoints);
            }
            throw new IllegalArgumentException("No activity with this id.");
        }
    }

    private List<TrackPoint> getTrackPoints(int id, Connection conn) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement("select * from track_point where id = ?;")) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                return loadTrackPointsToList(rs);
            }
        }
    }

    private List<TrackPoint> loadTrackPointsToList(ResultSet rs) throws SQLException {
        List<TrackPoint> trackpoints = new ArrayList<>();
        while (rs.next()) {
            trackpoints.add(newTrackPoint(rs));
        }
        return trackpoints;
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

    public List<Activity> listActivitiesBeforeDate(LocalDate date) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("select * from activities where start_time < ?;")) {

            LocalDateTime dateTime = date.atTime(0, 0);
            stmt.setTimestamp(1, Timestamp.valueOf(dateTime));
            return listActivitiesBeforeDateFromTable(stmt);
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot query.", sqle);
        }
    }

    private List<Activity> listActivitiesBeforeDateFromTable(PreparedStatement stmt) throws SQLException {

        List<Activity> activitiesFromTableBeforeDate = new ArrayList<>();

        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt(1);
                LocalDateTime startTime = rs.getTimestamp(2).toLocalDateTime();
                String description = rs.getString(3);
                ActivityType type = ActivityType.valueOf(rs.getString(4));
                activitiesFromTableBeforeDate.add(new Activity(id, startTime, description, type));
            }
        }
        return activitiesFromTableBeforeDate;
    }

    public void saveImageToActivity(long activityId, Image image) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("insert into images(id, filename, content) values (?, ?, ?);")) {
            Blob blob = conn.createBlob();
            blob.setBytes(1, image.getContent());
            stmt.setLong(1, activityId);
            stmt.setString(2, image.getFilename());
            stmt.setBlob(3, blob);
            stmt.executeUpdate();
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot save image into table.", sqle);
        }
    }

    public Image loadImageToActivity(long activityId, String filename) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("select * from images where id = ? and filename = ?;")) {
            stmt.setLong(1, activityId);
            stmt.setString(2, filename);
            return getImage(stmt, activityId, filename);
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot load image.", sqle);
        }
    }

    private Image getImage(PreparedStatement stmt, long activityId, String filename) throws SQLException {
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                byte[] content = rs.getBytes(3);
                return new Image(activityId, filename, content);
            }
            throw new IllegalArgumentException("No image with this id.");
        }
    }

    public List<TrackPoint> someTrackPoints(long activityId) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("select * from track_point where id = ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)) {
            stmt.setLong(1, activityId);
            List<TrackPoint> firstMediumLastTrackPoints = new ArrayList<>();
            addFirstMediumLastTrackPointsToList(stmt, firstMediumLastTrackPoints);
            return firstMediumLastTrackPoints;
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot list trackpoints.", sqle);
        }
    }

    private void addFirstMediumLastTrackPointsToList(PreparedStatement stmt, List<TrackPoint> firstMediumLastTrackPoints) throws SQLException {
        try (ResultSet rs = stmt.executeQuery()) {
            int size = getResultSetSize(rs);

            rs.first();
            firstMediumLastTrackPoints.add(newTrackPoint(rs));

            getMedium(rs, size, firstMediumLastTrackPoints);

            rs.last();
            firstMediumLastTrackPoints.add(newTrackPoint(rs));
        }
    }

    private int getResultSetSize(ResultSet rs) throws SQLException {
        int count = 0;
        while (rs.next()) {
            count++;
        }
        return count;
    }

    private TrackPoint newTrackPoint(ResultSet rs) throws SQLException {
        LocalDate time = rs.getDate(2).toLocalDate();
        double lat = rs.getDouble(3);
        double lon = rs.getDouble(4);

        return new TrackPoint(time, lat, lon);
    }

    private void getMedium(ResultSet rs, int size, List<TrackPoint> firstMediumLastTrackPoints) throws SQLException {
        if (size % 2 == 0) {
            rs.beforeFirst();
            rs.relative(size / 2 - 1);
            firstMediumLastTrackPoints.add(newTrackPoint(rs));
            rs.relative(1);
            firstMediumLastTrackPoints.add(newTrackPoint(rs));
        } else {
            rs.beforeFirst();
            rs.relative(size / 2 + 1);
            firstMediumLastTrackPoints.add(newTrackPoint(rs));
        }
    }

    private void setStmt(Activity activity, PreparedStatement stmt) throws SQLException {
        stmt.setTimestamp(1, Timestamp.valueOf(activity.getStartTime()));
        stmt.setString(2, activity.getDesc());
        stmt.setString(3, activity.getType().toString());
    }

    public void cleanTable() {
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate("drop table images;");
            stmt.executeUpdate("drop table track_point;");
            stmt.executeUpdate("drop table activities;");
            stmt.executeUpdate("CREATE TABLE activities (id INT AUTO_INCREMENT, start_time DATETIME, activity_desc VARCHAR(250), activity_type VARCHAR(10), PRIMARY KEY (id));");
            stmt.executeUpdate("CREATE TABLE track_point (id INT, tp_time DATE, lat DOUBLE(9, 7), lon DOUBLE(10, 7), FOREIGN KEY (id) REFERENCES activities(id));");
            stmt.executeUpdate("CREATE TABLE images (id INT, filename VARCHAR(250), content BLOB, FOREIGN KEY (id) REFERENCES activities(id));");
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot drop table and create new.", sqle);
        }
    }
}