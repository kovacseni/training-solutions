package kepesitovizsgagyakorlas.hegedusaniko.arraysexercises.percenteven;

public class Evens {

    public double percentEven(int[] numbers) {
        double count = 0.0;
        if (numbers.length == 0) {
            return count;
        }
        for (int i : numbers) {
            if (i % 2 == 0) {
                count++;
            }
        }
        return (count / numbers.length * 100);
    }
}
