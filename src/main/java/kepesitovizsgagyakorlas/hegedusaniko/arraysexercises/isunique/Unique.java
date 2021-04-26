package kepesitovizsgagyakorlas.hegedusaniko.arraysexercises.isunique;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Unique {

    public boolean isUnique(int[] numbers) {
        Set<Integer> setOfNumbers = new HashSet<>();
        for (int i : numbers) {
            setOfNumbers.add(i);
        }
        return setOfNumbers.size() == numbers.length;
    }

    public boolean isUnique2(int[] numbers) {
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i + 1] - numbers[i] == 0) {
                return false;
            }
        }
        return true;
    }
}
