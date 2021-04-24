package kepesitovizsgagyakorlas.hegedusaniko.arraysexercises.mingap;

public class Gap {

    public int minGap(int[] numbers) {
        if (numbers.length <= 1) {
            return 0;
        }
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < numbers.length - 1; i++) {
            int diff = numbers[i + 1] - numbers[i];
            if (diff < minDiff) {
                minDiff = diff;
            }
        }
        return minDiff;
    }
}
