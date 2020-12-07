package week07d01;

import java.util.ArrayList;
import java.util.List;

public class Fibonacci {

    public long fib(int n) {
        long nFibonacci = 0;

        if (n < 0) {
            throw new IllegalArgumentException("Adjon meg egy pozitív számot!");
        }

        if (n == 1) {
            nFibonacci = 1;
        }

        List<Integer> fibonacciList = new ArrayList<>();
        fibonacciList.add(0);
        fibonacciList.add(1);
        for (int i = 2; i < (n + 1); i++) {
            fibonacciList.add(fibonacciList.get(i - 2) + fibonacciList.get(i - 1));
        }

        nFibonacci = fibonacciList.get(n);

        return nFibonacci;
    }
}
