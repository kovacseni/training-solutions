package week11d02;

public class RideSenior {

    private int day;
    private int numberOfRide;
    private int km;

    public RideSenior(int day, int numberOfRide, int km) {
        if (day < 1 || day > 7) {
            throw new IllegalArgumentException("Illegal day!");
        }
        if (numberOfRide < 1) {
            throw new IllegalArgumentException("Illegal number of ride!");
        }
        if (km < 1) {
            throw new IllegalArgumentException("Illegal km!");
        }

        this.day = day;
        this.numberOfRide = numberOfRide;
        this.km = km;
    }

    public int getDay() {
        return day;
    }

    public int getNumberOfRide() {
        return numberOfRide;
    }

    public int getKm() {
        return km;
    }
}
