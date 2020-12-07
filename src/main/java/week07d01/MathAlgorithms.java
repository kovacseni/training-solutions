package week07d01;

public class MathAlgorithms {

    public boolean isPrime(int x) {
        if(x <= 0) {
            throw new IllegalArgumentException("Ez nem pozitív szám.");
        }

        boolean prime = true;
        if (x == 1) {
            prime = false;
        }

        if (x >= 2) {
            for (int i = 2; i <= Math.sqrt(x); i++) {
                if (x % i == 0) {
                    prime = false;
                    break;
                }
            }
        }
        return prime;
    }
}
