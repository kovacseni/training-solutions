package kepesitovizsgagyakorlas.hegedusaniko.arraysexercises.median;

import java.util.Arrays;

public class MedianFinder {

    public double median(int[] numbers) {
        Arrays.sort(numbers);
        if (numbers.length % 2 == 1) {
            int i = numbers.length / 2;
            return numbers[i];
        } else {
            int i = numbers.length / 2;
            double average = (numbers[i - 1] + numbers[i]) / 2.0;
            return average;
        }
    }
}
