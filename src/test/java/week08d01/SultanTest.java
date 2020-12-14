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

    @Test
    public void prisonBonusTest() {
        List<Integer> openList = Arrays.asList(1, 4, 9, 16, 25, 36, 49, 64, 81, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99);
        Assertions.assertEquals(openList, new Sultan().openDoorsBonus(86));
    }
}
