package kepesitovizsgagyakorlas.hegedusaniko.arraysexercises.kthlargest;

import java.util.Arrays;

public class KthLargest {

    public int kthLargest(int[] numbers, int k) {
        Arrays.sort(numbers);
        int result = 0;
        int count = 1;
        for (int i = k; i >= 0; i--) {
            result = numbers[numbers.length - count];
            count++;
        }
        return result;
    }
}
