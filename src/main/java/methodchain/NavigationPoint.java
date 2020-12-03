package methodchain;

public class NavigationPoint {

    private int distance;
    private int azimut;

    public NavigationPoint(int distance, int azimut) {
        this.distance = distance;
        this.azimut = azimut;
    }

    public double getDistance() {
        return distance;
    }

    public int getAzimut() {
        return azimut;
    }

    @Override
    public String toString() {
        return "distance: " + distance + " azimut: " + azimut;
    }
}
