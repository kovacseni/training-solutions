package week15d01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class MaxTest {

    @Test
    public void testMax() {
        Map<Integer, Integer> coordinates = new HashMap<>();
        coordinates.put(2, -3);
        coordinates.put(3, -4);
        coordinates.put(1, -2);
        coordinates.put(8, -9);
        coordinates.put(4, -5);

        Assertions.assertEquals(1, new Max().getMax(coordinates).getKey());
        Assertions.assertEquals(-2, new Max().getMax(coordinates).getValue());
    }
}
