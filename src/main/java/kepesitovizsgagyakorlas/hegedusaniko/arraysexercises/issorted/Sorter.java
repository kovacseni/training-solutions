package kepesitovizsgagyakorlas.hegedusaniko.arraysexercises.issorted;

public class Sorter {

    public static boolean isSorted(double[] numbers) {
        boolean sorted = true;
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] > numbers[i+1]) {
                sorted = false;
                break;
            }
        }
        return sorted;
    }
}
