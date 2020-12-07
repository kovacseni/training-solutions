package week07d01;

import java.util.Scanner;

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

    public static void main(String[] args) {
        MathAlgorithms m = new MathAlgorithms();
        System.out.println(m.isPrime(4));
        System.out.println(m.isPrime(2));
        System.out.println(m.isPrime(3));
        System.out.println(m.isPrime(6));
        System.out.println(m.isPrime(5));
        System.out.println(m.isPrime(49));
        System.out.println(m.isPrime(23));
        System.out.println(m.isPrime(2019));
    }
}
