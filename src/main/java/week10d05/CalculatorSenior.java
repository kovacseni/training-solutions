package week10d05;

import java.util.Arrays;
import java.util.Scanner;

public class CalculatorSenior {

    public void findMinMaxSum(int[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException("Adjon meg egy létező tömböt!");
        }

        int minSum = 0;
        int maxSum = 0;
        if (arr.length <= 4) {
            for (Integer i : arr) {
                minSum += i;
                maxSum += i;
            }
        } else {
            Arrays.sort(arr);
            minSum = arr[0] + arr[1] + arr[2] + arr[3];
            maxSum = arr[arr.length - 1] + arr[arr.length - 2] + arr[arr.length - 3] + arr[arr.length - 4];
        }
        System.out.println("A 4 legkisebb szám összege: " + minSum);
        System.out.println("A 4 legnagyobb szám összege: " + maxSum);
    }

    public static void main(String[] args) {

        System.out.println("Adja meg, hány elemet szeretne a tömbbe rakni!");
        Scanner scanner = new Scanner(System.in);
        int intArray = Integer.parseInt(scanner.nextLine());
        int[] arr = new int[intArray];
        System.out.println("Sorban egymás után írja be a számokat (csak egész számokat adjon meg)!");
        for (int i = 0; i < intArray; i++) {
            arr[i] = Integer.parseInt(scanner.nextLine());
        }
        new CalculatorSenior().findMinMaxSum(arr);
    }
}
