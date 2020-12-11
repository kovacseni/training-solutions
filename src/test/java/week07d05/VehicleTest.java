package week07d05;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VehicleTest {

    @Test
    public void testAll() {
        Vehicle vehicle = new Vehicle();
        Car car = new Car();
        Truck truck = new Truck();
        Motorcycle motorcycle = new Motorcycle();

        Assertions.assertEquals(5, vehicle.getNumberOfGears());
        Assertions.assertEquals(TransmissionType.MANUAL, vehicle.getTransmissionType());
        Assertions.assertEquals(5, car.getNumberOfGears());
        Assertions.assertEquals(TransmissionType.AUTOMATIC, car.getTransmissionType());
        Assertions.assertEquals(5, truck.getNumberOfGears());
        Assertions.assertEquals(TransmissionType.MANUAL, truck.getTransmissionType());
        Assertions.assertEquals(5, motorcycle.getNumberOfGears());
        Assertions.assertEquals(TransmissionType.SEQUENTIAL, motorcycle.getTransmissionType());
    }
}
