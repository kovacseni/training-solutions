package week10d02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class MaxTravelTest {

    @Test
    public void testMaxTravel() {
        List<Integer> busStop = Arrays.asList(12, 12, 0, 3, 4, 4, 5, 2, 24, 29, 15, 12, 18, 21, 4, 12, 17);
        Assertions.assertEquals(12, new MaxTravel().getMaxIndex(busStop));
    }
}
