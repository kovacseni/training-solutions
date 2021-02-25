package activitytracker;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Activity {

    private int id;
    private LocalDateTime startTime;
    private String desc;
    private ActivityType type;
    private List<TrackPoint> trackpoints;

    public Activity(LocalDateTime startTime, String desc, ActivityType type) {
        this.startTime = startTime;
        this.desc = desc;
        this.type = type;
    }

    public Activity(int id, LocalDateTime startTime, String desc, ActivityType type) {
        this(startTime, desc, type);
        this.id = id;
    }

    public Activity(LocalDateTime startTime, String desc, ActivityType type, List<TrackPoint> trackpoints) {
        this(startTime, desc, type);
        this.trackpoints = trackpoints;
    }

    public Activity(int id, LocalDateTime startTime, String desc, ActivityType type, List<TrackPoint> trackpoints) {
        this(id, startTime, desc, type);
        this.trackpoints = trackpoints;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public String getDesc() {
        return desc;
    }

    public ActivityType getType() {
        return type;
    }

    public List<TrackPoint> getTrackpoints() {
        return new ArrayList<>(trackpoints);
    }

    @Override
    public String toString() {
        return "Activity{" +
                "id=" + id +
                ", startTime=" + startTime +
                ", desc='" + desc + '\'' +
                ", type=" + type +
                ", trackpoints=" + trackpoints +
                '}';
    }
}
