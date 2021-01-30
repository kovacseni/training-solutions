package week11d02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

public class CourierSeniorTest {

    private CourierSenior courier;

    @BeforeEach
    public void setUp() {
        Path path = Path.of("src/main/resources/rides.txt");
        courier = new CourierSenior(path);
    }

    @Test
    public void testFirstRideOfWeek() {
        Assertions.assertEquals(2, courier.firstRideOfWeek().getDay());
        Assertions.assertEquals(1, courier.firstRideOfWeek().getRideNumber());
        Assertions.assertEquals(2, courier.firstRideOfWeek().getKm());
    }

    @Test
    public void testDaysWithoutWork() {
        Set<Integer> expected = new HashSet<>();
        expected.add(1);
        expected.add(5);

        Assertions.assertEquals(2, courier.daysWithoutWork().size());
        Assertions.assertEquals(expected, courier.daysWithoutWork());
    }

    @Test
    public void testgetDailyKm() {
        int[] expected = new int[] {0, 56, 13, 31, 0, 33, 34};

        Assertions.assertArrayEquals(expected, courier.getDailyKm());
    }
}
