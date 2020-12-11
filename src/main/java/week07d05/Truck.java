package week07d05;

public class Truck extends Vehicle {

    private int numberOfGears;
    private TransmissionType transmissionType;

    public Truck() {
        this.numberOfGears = super.getNumberOfGears();
        this.transmissionType = TransmissionType.MANUAL;
    }
}
