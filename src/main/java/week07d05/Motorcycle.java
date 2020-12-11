package week07d05;

public class Motorcycle extends Vehicle {

    private int numberOfGears;
    private TransmissionType transmissionType;

    public Motorcycle() {
        this.numberOfGears = super.getNumberOfGears();
            this.transmissionType = TransmissionType.SEQUENTIAL;
        }
    }
