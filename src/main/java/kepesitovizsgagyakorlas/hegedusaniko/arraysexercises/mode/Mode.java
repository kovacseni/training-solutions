package kepesitovizsgagyakorlas.hegedusaniko.arraysexercises.mode;

import java.util.HashMap;
import java.util.Map;

public class Mode {

    public int mode(int[] numbers) {
        Map<Integer, Integer> numberMap = new HashMap<>();
        for (int i : numbers) {
            if (i < 0 || i > 100) {
                throw new IllegalArgumentException("Invalid number");
            }
            if (!numberMap.containsKey(i)) {
                numberMap.put(i, 1);
            } else {
                numberMap.put(i, numberMap.get(i) + 1);
            }
        }
        return getMax(numberMap);
    }

    private int getMax(Map<Integer, Integer> numberMap) {
        int max = 0;
        int number = 0;
        for (int i : numberMap.keySet()) {
            if (numberMap.get(i) > max) {
                max = numberMap.get(i);
                number = i;
            }
        }
        return number;
    }
}
