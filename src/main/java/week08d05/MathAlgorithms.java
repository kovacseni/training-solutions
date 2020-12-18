package week08d05;

import java.util.ArrayList;
import java.util.List;

public class MathAlgorithms {

    public int greatestCommonDivisor(int a, int b) {
        List<Integer> aDivisor = new ArrayList<>();
        List<Integer> bDivisor = new ArrayList<>();

        for (int i = 1; i <= a; i++) {
            if (a % i == 0) {
                aDivisor.add(i);
            }
        }

        for (int i = 1; i <= b; i++) {
            if (b % i == 0) {
                bDivisor.add(i);
            }
        }

        List <Integer> commonDivisors = new ArrayList<>();
        for (int i = 0; i < aDivisor.size(); i++) {
            if (bDivisor.contains(aDivisor.get(i))) {
                commonDivisors.add(aDivisor.get(i));
            }
        }

        int greatest = commonDivisors.get(0);
        for (Integer i : commonDivisors) {
            if (i > greatest) {
                greatest= i;
            }
        }
        return greatest;
    }
}
