package week10d05;

import java.util.Arrays;

public class Calculator {

    public int findMinSum(int[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException("Adjon meg egy létező tömböt!");
        }

        int minSum = 0;
        if (arr.length <= 4) {
            for (Integer i : arr) {
                minSum += i;
            }
        } else {
           Arrays.sort(arr);
           minSum = arr[0] + arr[1] + arr[2] + arr[3];
        }
        return minSum;
    }
}
