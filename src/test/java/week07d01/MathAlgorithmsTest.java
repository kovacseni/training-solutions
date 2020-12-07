package week07d01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MathAlgorithmsTest {

    @Test
    public void testPrimeMinus1() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new MathAlgorithms().isPrime(-1);
        });
        assertEquals("Ez nem pozitív szám.", ex.getMessage());
    }

    @Test
    public void testPrime0() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new MathAlgorithms().isPrime(0);
        });
        assertEquals("Ez nem pozitív szám.", ex.getMessage());
    }

    @Test
    public void testPrime1() {
        Assertions.assertFalse(new MathAlgorithms().isPrime(1));
    }

    @Test
    public void testPrime2() {
        Assertions.assertTrue(new MathAlgorithms().isPrime(2));
    }

    @Test
    public void testPrime3() {
        Assertions.assertTrue(new MathAlgorithms().isPrime(3));
    }

    @Test
    public void testPrime4() {
        Assertions.assertFalse(new MathAlgorithms().isPrime(4));
    }

    @Test
    public void testPrime25() {
        Assertions.assertFalse(new MathAlgorithms().isPrime(25));
    }

    @Test
    public void testPrime47() {
        Assertions.assertTrue(new MathAlgorithms().isPrime(47));
    }

    @Test
    public void testPrime64() {
        Assertions.assertFalse(new MathAlgorithms().isPrime(64));
    }

    @Test
    public void testPrime121() {
        Assertions.assertFalse(new MathAlgorithms().isPrime(121));
    }

    @Test
    public void testPrime2019() {
        Assertions.assertFalse(new MathAlgorithms().isPrime(2019));
    }
}
