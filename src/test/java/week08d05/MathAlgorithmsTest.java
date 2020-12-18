package week08d05;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MathAlgorithmsTest {

    @Test
    public void testMethod() {
        Assertions.assertEquals(6, new MathAlgorithms().greatestCommonDivisor(24, 54));
    }
}
