package week15d01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class BitCoinTest {

    @Test
    public void testGetBest() {
        List<Integer> rates = Arrays.asList(454, 86, 2, 5, 14, 432, 64, 23, 754, 32);

        Assertions.assertEquals(2, new BitCoinExchange().getBest(rates).getPurchase());
        Assertions.assertEquals(8, new BitCoinExchange().getBest(rates).getSale());
    }
}
