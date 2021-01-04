package week10d01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class HikingTest {

    private List<GPSCoordinates> listOfGPSCoordinates;

    @BeforeEach
    public void setUp() {
        listOfGPSCoordinates = new ArrayList<>();
        listOfGPSCoordinates.add(new GPSCoordinates(47.497913, 19.040236, 10));
        listOfGPSCoordinates.add(new GPSCoordinates(47.497912, 19.040232, 20));
        listOfGPSCoordinates.add(new GPSCoordinates(47.497916, 19.040238, 15));
        listOfGPSCoordinates.add(new GPSCoordinates(47.497918, 19.040234, 18));
    }

    @Test
    public void testGetPlusElevation() {
        Assertions.assertEquals(13, new Hiking().getPlusElevation(listOfGPSCoordinates));
    }
}
