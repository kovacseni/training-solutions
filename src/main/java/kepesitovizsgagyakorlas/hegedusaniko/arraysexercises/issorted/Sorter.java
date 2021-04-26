package kepesitovizsgagyakorlas.hegedusaniko.arraysexercises.issorted;

public class Sorter {

    public static boolean isSorted(double[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] > numbers[i+1]) {
                return false;
            }
        }
        return true;
    }
}
