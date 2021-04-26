package kepesitovizsgagyakorlas.hegedusaniko.arraysexercises.longestsortedsequence;

import java.util.ArrayList;
import java.util.List;

public class Sequence {

    public int longestSortedSequence(int[] numbers) {
        List<Integer> maxCounts = new ArrayList<>();
        int count = 1;
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i + 1] >= numbers[i]) {
                count++;
            } else {
                maxCounts.add(count);
                count = 1;
            }
        }
        return getMax(maxCounts);
    }

    private int getMax(List<Integer> maxCounts) {
        int max = 0;
        for (int i : maxCounts) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }
}
