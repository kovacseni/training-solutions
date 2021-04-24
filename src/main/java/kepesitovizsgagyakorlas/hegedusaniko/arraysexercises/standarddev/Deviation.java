package kepesitovizsgagyakorlas.hegedusaniko.arraysexercises.standarddev;

public class Deviation {

    public double standardDeviation(double[] numbers) {
        double average = getAverage(numbers);
        double[] differences = getDifferences(numbers, average);
        double sumOfDifferencesSquares = getSumOfDifferencesSquares(differences);

        return Math.sqrt(sumOfDifferencesSquares / (numbers.length - 1));
    }

    private double getAverage(double[] numbers) {
        double sum = 0.0;
        for (double d : numbers) {
            sum += d;
        }
        double average = sum / numbers.length;
        return average;
    }

    private double[] getDifferences(double[] numbers, double average) {
        double[] differences = new double[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            differences[i] = numbers[i] - average;
        }
        return differences;
    }

    private double getSumOfDifferencesSquares(double[] differences) {
        double sum = 0.0;
        for (double d : differences) {
            sum += d * d;
        }
        return sum;
    }
}
