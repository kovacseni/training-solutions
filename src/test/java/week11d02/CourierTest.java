package week11d02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CourierTest {

    private List<Ride> rides;

    @Test
    public void testEmptyList() {
        Courier courier = new Courier();
        rides = courier.getRides();
        courier.addRide(new Ride(3, 1, 42));
        Assertions.assertEquals(1, rides.size());
        Assertions.assertEquals(3, rides.get(0).getDay());
        Assertions.assertEquals(1, rides.get(0).getRideNumber());
        Assertions.assertEquals(42, rides.get(0).getKm());
    }

    @Test
    public void testEmptyListWithIncorrectParameter() {
        Courier courier = new Courier();
        rides = courier.getRides();
        IllegalArgumentException iae = Assertions.assertThrows(IllegalArgumentException.class, () -> courier.addRide(new Ride(3, 3, 42)));
        Assertions.assertEquals("Incorrect ride", iae.getMessage());
    }

    @Test
    public void testList() {
        Courier courier = new Courier();
        rides = courier.getRides();
        courier.addRide(new Ride(1, 1, 4));
        courier.addRide(new Ride(2, 1, 34));
        courier.addRide(new Ride(2, 2, 23));
        courier.addRide(new Ride(2, 3, 12));
        courier.addRide(new Ride(3, 1, 45));
        courier.addRide(new Ride(3, 2, 38));
        courier.addRide(new Ride(5, 1, 36));

        IllegalArgumentException iae = Assertions.assertThrows(IllegalArgumentException.class, () -> courier.addRide(new Ride(3, 3, 42)));
        Assertions.assertEquals("Incorrect ride", iae.getMessage());
        Assertions.assertEquals(2, rides.get(1).getDay());
        Assertions.assertEquals(3, rides.get(3).getRideNumber());
        Assertions.assertEquals(38, rides.get(5).getKm());
        Assertions.assertEquals(4, courier.noWork());
    }
}
