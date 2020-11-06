package debug.numbers;

import java.util.ArrayList;
import java.util.List;

public class NumberStatistics {

    private List<Integer> numbers;

    public NumberStatistics (List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int sumPositives() {
        int sum = 0;
        for(int n: numbers) {
            if(n > 0) {
                sum += n;
            }
        }
        return sum;
    }

    public int minDifferenceBetweenNeighbours() {
        int minDifference = numbers.get(0) - numbers.get(1) >= 0 ? numbers.get(0) - numbers.get(1) : numbers.get(1) - numbers.get(0);
        for(int i = 1; i < numbers.size() - 1; i++) {
            int actDifference = numbers.get(i) - numbers.get(i + 1);
            if(actDifference < minDifference) {
                minDifference = actDifference;
            }
        }
        return minDifference;
    }

    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>();
        NumberStatistics n = new NumberStatistics(numbers);

        numbers = List.of(4, 2, 1, 7, 9, 31, 64, 42, 13, 35, 53, -2, -51, -86, -1, -82, -6, -24);
        System.out.println(n.sumPositives());
        System.out.println(n.minDifferenceBetweenNeighbours());
    }

    /* Ezzel a feladattal sajnos összesen eddig jutottam.*/
}
