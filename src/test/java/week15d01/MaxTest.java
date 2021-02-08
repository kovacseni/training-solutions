package week15d01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class MaxTest {

    @Test
    public void testMax() {
        Map<Integer, Integer> coordinates = new HashMap<>();
        coordinates.put(2, 3);
        coordinates.put(3, 4);
        coordinates.put(1, 2);
        coordinates.put(8, 9);
        coordinates.put(4, 5);
        int[] expected = new int[] {8, 9};

        Assertions.assertArrayEquals(expected, new Max(coordinates).getMax());
    }
}
