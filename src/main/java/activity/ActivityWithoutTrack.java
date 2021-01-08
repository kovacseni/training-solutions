package activity;

public class ActivityWithoutTrack implements Activity {

    private ActivityType activityType;

    public ActivityWithoutTrack(ActivityType activityType) {
        this.activityType = activityType;
    }

    @Override
    public double getDistance() {
        double distance = 0;
        return distance;
    }

    @Override
    public ActivityType getType() {
        return activityType;
    }
}
