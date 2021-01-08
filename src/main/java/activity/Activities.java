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
            if (a.getClass() == ActivityWithTrack.class) {
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
        reportList.add(new Report(ActivityType.BIKING, getBikingDistance()));
        reportList.add(new Report(ActivityType.HIKING, getHikingDistance()));
        reportList.add(new Report(ActivityType.RUNNING, getRunningDistance()));
        reportList.add(new Report(ActivityType.BASKETBALL, getBasketballDistance()));

        return reportList;
    }

    private double getBikingDistance() {
        double bikingDistance = 0;
        for (Activity a : activities) {
            if (a.getType() == ActivityType.BIKING) {
                bikingDistance += a.getDistance();
            }
        }
        return bikingDistance;
    }

    private double getHikingDistance() {
        double hikingDistance = 0;
        for (Activity a : activities) {
            if (a.getType() == ActivityType.HIKING) {
                hikingDistance += a.getDistance();
            }
        }
        return hikingDistance;
    }

    private double getRunningDistance() {
        double runningDistance = 0;
        for (Activity a : activities) {
            if (a.getType() == ActivityType.RUNNING) {
                runningDistance += a.getDistance();
            }
        }
        return runningDistance;
    }

    private double getBasketballDistance() {
        double basketballDistance = 0;
        for (Activity a : activities) {
            if (a.getType() == ActivityType.BASKETBALL) {
                basketballDistance += a.getDistance();
            }
        }
        return basketballDistance;
    }
}
