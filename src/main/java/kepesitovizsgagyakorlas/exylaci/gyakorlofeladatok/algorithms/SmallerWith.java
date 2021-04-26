package kepesitovizsgagyakorlas.exylaci.gyakorlofeladatok.algorithms;

public class SmallerWith {

    public int smallerWith(int number, int... numbers) {
        validateParameters(number, numbers);
        int max = getMax(numbers);
        int limit = max - number;
        int expected = Integer.MIN_VALUE;
        for (int i : numbers) {
            if (i > expected && i <= limit) {
                expected = i;
            }
        }
        if (expected == Integer.MIN_VALUE) {
            throw new IllegalStateException("There is no such number!");
        }
        return expected;
    }

    private void validateParameters(int number, int... numbers) {
        if (number < 0) {
            throw new IllegalArgumentException("Value is out of range!");
        }
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("Every parameter is a must!");
        }
    }

    private int getMax(int[] numbers) {
        int max = numbers[0];
        for (int i : numbers) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }
}
