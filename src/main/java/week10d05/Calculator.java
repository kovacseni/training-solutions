package week10d05;

import java.util.Arrays;
import java.util.List;

public class Calculator {

    public void findMinSum(int[] arr) {
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
        System.out.println(minSum);
    }

    public static void main(String[] args) {
        int[] arr1 = {3, 9, 7, 5, 1};
        int[] arr2 = {3, 1, 5};
        int[] arr3 = {3, 1, 9, 7, 3, 1, 9, 7, 3, 5, 7};
        int[] arr4 = {3, -3, -5, 1, -7, 7, 9};
        new Calculator().findMinSum(arr1);
        new Calculator().findMinSum(arr2);
        new Calculator().findMinSum(arr3);
        new Calculator().findMinSum(arr4);
    }
}
