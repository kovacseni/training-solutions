package activity;

public class ActivityWithTrack implements Activity {

    private Track track;
    private ActivityType activityType;

    public ActivityWithTrack(Track track, ActivityType activityType) {
        this.track = track;
        this.activityType = activityType;
    }

    @Override
    public double getDistance() {
        double distance = track.getDistance();
        return distance;
    }

    @Override
    public ActivityType getType() {
        return activityType;
    }
}
