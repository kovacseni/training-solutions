package virtualmethod.vehicle;

public class Car extends Vehicle {

    private int numberPassenger;

    public Car(int kg, int numberPassenger) {
        super(kg);
        this.numberPassenger = numberPassenger;
    }

    public int getNumberPassenger() {
        return numberPassenger;
    }

    @Override
    public int getGrossLoad() {
        return numberPassenger * PERSON_AVERAGE_WEIGHT + super.getGrossLoad();
    }

    @Override
    public String toString() {
        return "Car{numberOfPassenger=" + numberPassenger + ", vehicleWeight=" + super.getVehicleWeight() + '}';
    }
}
