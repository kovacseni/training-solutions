package activity;

import java.util.ArrayList;
import java.util.List;

public class Activities {

    private List<Activity> activities;

    public Activities(List<Activity> activities) {
        this.activities = activities;
    }

    public void addActivity(Activity activity) {
        activities.add(activity);
    }

    public int numberOfTrackActivities() {
        int trackActivities = 0;
        for (Activity a : activities) {
            if (a instanceof ActivityWithTrack) {
                trackActivities++;
            }
        }
        return trackActivities;
    }

    public int numberOfWithoutTrackActivities() {
        int withoutTrackActivities = 0;
        for (Activity a : activities) {
            if (a.getClass() == ActivityWithoutTrack.class) {
                withoutTrackActivities++;
            }
        }
        return withoutTrackActivities;
    }

    public List<Report> distancesByTypes() {
        List<Report> reportList = new ArrayList<>();
        for (ActivityType a : ActivityType.values()) {
            reportList.add(new Report(a, getDistanceByType(a)));
        }
        return reportList;
    }

    private double getDistanceByType(ActivityType activityType) {
        double distanceByType = 0;
        for (Activity a : activities) {
            if (a.getType() == activityType) {
                distanceByType += a.getDistance();
            }
        }
        return distanceByType;
    }
}
