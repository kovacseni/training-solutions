package week11d02;

public class Ride {

    private int day;
    private int rideNumber;
    private int km;

    public Ride(int day, int rideNumber, int km) {
        if (day < 1 || day > 7) {
            throw new IllegalArgumentException("Incorrect day");
        }
        if (rideNumber < 1) {
            throw new IllegalArgumentException("Incorrect ride");
        }
        if (km < 1) {
            throw new IllegalArgumentException("Incorrect distance");
        }

        this.day = day;
        this.rideNumber = rideNumber;
        this.km = km;
    }

    public int getDay() {
        return day;
    }

    public int getRideNumber() {
        return rideNumber;
    }

    public int getKm() {
        return km;
    }
}
