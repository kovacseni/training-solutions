package kepesitovizsgagyakorlas.hegedusaniko.arraysexercises.lastindexof;

public class LastIndexOf {

    public int lastIndexOf(int[] numbers, int number) {
        for (int i = numbers.length - 1; i >= 0; i--) {
            if (numbers[i] == number) {
                return i;
            }
        }
        return -1;
    }
}
