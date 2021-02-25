package week17d04;

import activitytracker.Activity;
import activitytracker.TrackPoint;

import javax.sql.DataSource;
import java.sql.*;

public class ActivityTransaction {

    private DataSource dataSource;

    public ActivityTransaction(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void saveActivityAndSaveTrackPoints(Activity activity) {
        try (Connection conn = dataSource.getConnection()) {
            conn.setAutoCommit(false);

            int activityId = saveActivitywithTrackPoints(activity, conn);
            saveTrackPoints(activityId, activity, conn);

            conn.commit();

        } catch (Exception e) {
            throw new IllegalArgumentException("Transaction not succeeded!");
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
        } catch (Exception ex) {
            conn.rollback();
            throw new IllegalArgumentException("Invalid activity!");
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
        } catch (Exception ex) {
            conn.rollback();
            throw new IllegalArgumentException("Invalid trackpoint(s)!");
        }
    }
}
