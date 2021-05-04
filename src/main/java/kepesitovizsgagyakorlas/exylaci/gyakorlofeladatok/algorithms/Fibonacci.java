package kepesitovizsgagyakorlas.exylaci.gyakorlofeladatok.algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Fibonacci {

    private int fibonacciNumber1 = 1;
    private int fibonacciNumber2 = 1;
    private  int count = 1;

    public String getPrims(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Invalid parameter!");
        }
        Set<Integer> primes = new TreeSet<>();
        int fibonacciCount = 1;
        while (fibonacciCount <= number) {
            int nextNumber = getNextFibonacciNumber();
            if (isNextNumberPrime(nextNumber)) {
                primes.add(nextNumber);
            }
            fibonacciCount++;
        }
        String expected = primes.toString();
        return expected.substring(1, expected.length() - 1);
    }

    public List<Integer> getPiecesPrims(int number) {
        List<Integer> primes = new ArrayList<>();
        int primeCount = 1;
        while (primeCount <= number) {
            int nextNumber = getNextFibonacciNumber();
            if (isNextNumberPrime(nextNumber)) {
                primes.add(nextNumber);
                primeCount++;
            }
        }
        return primes;
    }

    private int getNextFibonacciNumber() {
        if (count <= 2) {
            count++;
            return 1;
        }
        int nextNumber = fibonacciNumber1 + fibonacciNumber2;
        fibonacciNumber1 = fibonacciNumber2;
        fibonacciNumber2 = nextNumber;
        count++;
        return nextNumber;
    }

    private boolean isNextNumberPrime(int nextNumber) {
        int nextNumberCount = 0;
        for (int i = 1; i <= nextNumber; i++) {
            if (nextNumber % i == 0) {
                nextNumberCount++;
            }
        }
        return nextNumberCount <= 2;
    }
}
