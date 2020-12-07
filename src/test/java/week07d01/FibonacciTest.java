package week07d01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FibonacciTest {

    @Test
    public void testFibonacciMinus1() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new Fibonacci().fib(-1);
        });
        assertEquals("Adjon meg egy pozitív számot!", ex.getMessage());
    }

    @Test
    public void testFibonacci0() {
        Assertions.assertEquals(0, new Fibonacci().fib(0));
    }

    @Test
    public void testFibonacci1() {
        Assertions.assertEquals(1, new Fibonacci().fib(1));
    }

    @Test
    public void testFibonacci2() {
        Assertions.assertEquals(1, new Fibonacci().fib(2));
    }

    @Test
    public void testFibonacci3() {
        Assertions.assertEquals(2, new Fibonacci().fib(3));
    }

    @Test
    public void testFibonacci4() {
        Assertions.assertEquals(3, new Fibonacci().fib(4));
    }

    @Test
    public void testFibonacci5() {
        Assertions.assertEquals(5, new Fibonacci().fib(5));
    }

    @Test
    public void testFibonacci6() {
        Assertions.assertEquals(8, new Fibonacci().fib(6));
    }

    @Test
    public void testFibonacci7() {
        Assertions.assertEquals(13, new Fibonacci().fib(7));
    }

    @Test
    public void testFibonacci8() {
        Assertions.assertEquals(21, new Fibonacci().fib(8));
    }

    @Test
    public void testFibonacci9() {
        Assertions.assertEquals(34, new Fibonacci().fib(9));
    }
}
