package methodchain;

import java.util.ArrayList;
import java.util.List;

public class Robot {

    private int distance;
    private int azimut;
    private List<NavigationPoint> navigationList = new ArrayList<>();

    public double getDistance() {
        return distance;
    }

    public int getAzimut() {
        return azimut;
    }
    public Robot go(int meter) {
        this.distance += meter;
        return this;
    }

    public Robot rotate(int angle) {
        this.azimut += angle;
        return this;
    }

    public Robot registerNavigationPoint() {
        navigationList.add(new NavigationPoint(this.distance, this.azimut));
        return this;
    }

    public List<NavigationPoint> getNavigationList() {
        return navigationList;
    }


}
