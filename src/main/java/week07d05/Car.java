package week07d05;

public class Car extends Vehicle {

    private int numberOfGears;
    private TransmissionType transmissionType;

    public Car() {
        this.numberOfGears = super.getNumberOfGears();
        this.transmissionType = TransmissionType.AUTOMATIC;
    }

    @Override
    public int getNumberOfGears() {
        return numberOfGears;
    }

    @Override
    public TransmissionType getTransmissionType() {
        return transmissionType;
    }
}
