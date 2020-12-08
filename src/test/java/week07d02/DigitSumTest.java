package week07d02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DigitSumTest {

    @Test
    public void digitSumTest() {
        Assertions.assertEquals(6, new DigitSum().sumOfDigits(123));
    }
}

