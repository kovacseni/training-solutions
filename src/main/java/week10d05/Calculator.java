package week10d05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Calculator {

    public int findMinSum(int[] arr) {
        int minSum = 0;
        if (arr.length <= 4) {
            for (Integer i : arr) {
                minSum += i;
            }
        } else {
            List<Integer> integerList = new ArrayList<>();
            for (Integer i : arr) {
                integerList.add(i);
            }
            Collections.sort(integerList);
            minSum = integerList.get(0) + integerList.get(1) + integerList.get(2) + integerList.get(3);
        }
        return minSum;
    }
}
