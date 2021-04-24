package kepesitovizsgagyakorlas.hegedusaniko.arraysexercises.range;

public class RangeFinder {

    public static int range(int[] numbers) {
        int min = numbers[0];
        int max = numbers[0];
        for (int i : numbers) {
            if (i < min) {
                min = i;
            } else if (i > max) {
                max = i;
            }
        }
        return (max - min + 1);
    }
}
