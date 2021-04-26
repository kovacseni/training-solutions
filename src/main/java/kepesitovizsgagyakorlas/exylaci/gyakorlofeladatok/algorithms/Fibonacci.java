package kepesitovizsgagyakorlas.exylaci.gyakorlofeladatok.algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Fibonacci {

  public String getPrims(int number) {
      if (number < 0) {
          throw new IllegalArgumentException("Invalid parameter!");
      }
      Set<Integer> fibonacci = new TreeSet<>(getPrimsOfFibonacci(number));
      String expected = fibonacci.toString();
      return expected.substring(1, expected.length() - 1);
  }

  private List<Integer> getPrimsOfFibonacci(int number) {
      if (number <= 1) {
          return validateParameter(number);
      }
      List<Integer> fibonacci = getFibonacci(number);
      return getPrimsOfFibonacci(fibonacci);
  }

    private List<Integer> validateParameter(int number) {
        if (number == 1) {
            return List.of(1);
        }
        return new ArrayList<>();
    }

    private List<Integer> getFibonacci(int number) {
        List<Integer> fibonacci = new ArrayList<>();
        fibonacci.add(1);
        fibonacci.add(1);
        for (int i = 1; i < fibonacci.size() - 1; i++) {
            fibonacci.add(fibonacci.get(i - 1) + fibonacci.get(i));
        }
        return fibonacci;
    }

    private List<Integer> getPrimsOfFibonacci(List<Integer> fibonacci) {
        List<Integer> prims = new ArrayList<>();
        int count = 0;
        for (int i : fibonacci) {
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    count++;
                }
            }
            if (count <= 2) {
                prims.add(i);
            }
            count = 0;
        }
        return prims;
    }

    public List<Integer> getPiecesPrims(int number) {
      List<Integer> primes = new ArrayList<>();
      while (number > 0) {
          primes.add(getNextPrimeOfFibonacci(primes.get(primes.size())));
          number--;
      }
      return primes;
    }

    private int getNextPrimeOfFibonacci(int lastPrime) {
      List<Integer> fibonacci = getFibonacci(lastPrime);
      List<Integer> primes = fibonacci.stream().filter(i -> isPrime(i)).limit(lastPrime + 1).collect(Collectors.toList());
      return primes.get(primes.size() - 1);
    }

    private boolean isPrime(int number) {
      int count = 0;
      for (int i = 1; i <= number; i++) {
          if (number % i == 0) {
              count++;
          }
      }
      return count <= 2;
    }

    /*  public String getPrims(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Invalid parameter!");
        }
        String expected = getPiecesPrims(number).toString();
        return expected.substring(1, expected.length() - 1);
    }

    public List<Integer> getPiecesPrims(int number) {
        if (number <= 1) {
            return validateParameter(number);
        }
        int[] fibonacci = getFibonacci(number);
        return getPrimsOfFibonacci(fibonacci);
    }

    private List<Integer> validateParameter(int number) {
        if (number == 1) {
            return List.of(1);
        }
        return new ArrayList<>();
    }

    private int[] getFibonacci(int number) {
        int[] fibonacci = new int[number];
        fibonacci[0] = 1;
        fibonacci[1] = 1;
        for (int i = 1; i < fibonacci.length - 1; i++) {
            fibonacci[i + 1] = fibonacci[i - 1] + fibonacci[i];
        }
        return fibonacci;
    }

    private List<Integer> getPrimsOfFibonacci(int[] fibonacci) {
        List<Integer> prims = new ArrayList<>();
        int count = 0;
        for (int i : fibonacci) {
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    count++;
                }
            }
            if (count == 1 || count == 2) {
                prims.add(i);
            }
            count = 0;
        }
        return prims;
    }*/
}
