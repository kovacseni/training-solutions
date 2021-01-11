package week11d01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PairFinder {

    List<Integer> numberList = new ArrayList<>();

    public int findPairs(int[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException("Invalid array;");
        }
        Arrays.sort(arr);
        sumNumbers(arr);
        int sum = 0;
        for (Integer i : numberList) {
            sum += (i / 2);
        }
        return sum;
    }

    private void sumNumbers(int[] arr) {
        int sum = 1;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] == arr[i]) {
                sum++;
            } else if (arr[i + 1] != arr[i]) {
                numberList.add(sum);
                sum = 1;
            }
        }
    }
}
