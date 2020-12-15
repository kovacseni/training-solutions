package week08d02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class LotteryTest {

    @Test
    public void lotteryTest() {
        List<Integer> lotteryNumbers = Arrays.asList(16, 29, 38, 34, 45);
        Assertions.assertEquals(lotteryNumbers, new Lottery().getNumbers());
    }
}
