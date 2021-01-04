package week09d02;

import java.util.ArrayList;
import java.util.List;

public class FibCalculator {

    public long sumEvens(int bound) {
        if (bound <= 0) {
            throw new IllegalArgumentException("Adjon meg egy pozitív számot!");
        }
        List<Long> fibonacciList = new ArrayList<>();
        long sum = 0;

        if (bound >= 1) {
            fibonacciList = fibonacci(bound);
            for (int i = 0;i < fibonacciList.size() - 1; i++) {
                if (fibonacciList.get(i) % 2 == 0) {
                    sum += fibonacciList.get(i);
                }
            }
        }
        return sum;
    }

    private List<Long> fibonacci(int bound) {
        List<Long> fibonacciList = new ArrayList<>();

        int i = 2;
        fibonacciList.add(0L);
        fibonacciList.add(1L);
        do {
            fibonacciList.add(fibonacciList.get(i - 2) + fibonacciList.get(i - 1));
            i++;
        } while (fibonacciList.get(i - 1) <= bound);
        return fibonacciList;
    }
}
