package week08d01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class SultanTest {

    @Test
    public void prisonTest() {
        List<Integer> openList = Arrays.asList(1, 4, 9, 16, 25, 36, 49, 64, 81, 100);
        Assertions.assertEquals(openList, new Sultan().openDoors());
    }
}
