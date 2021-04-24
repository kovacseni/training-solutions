package kepesitovizsgagyakorlas.hegedusaniko.arraysexercises.countinrange;

public class CountInRange {

    public int countInRange(int[] numbers, int min, int max) {
        int count = 0;
        for (int i : numbers) {
            if (i > min && i < max) {
                count++;
            }
        }
        return count;
    }
}
