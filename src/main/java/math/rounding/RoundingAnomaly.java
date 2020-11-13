package math.rounding;

import java.util.Random;

public class RoundingAnomaly {

    private int size;
    private double max;
    private int scale;

    private double[] randomNumbers(int size, double max, int scale) {
        double[] numbers = new double[size];
        Random random = new Random();
        double d1 = Math.pow(10, scale);
        for (int i = 0; i < size; i++) {
            double d2 = Math.round(random.nextDouble() * max * d1) / d1;
            numbers[i] = d2;
        }
        return numbers;
    }

    private double roundAfterSum(double[] numbers) {
        double osszeg = 0;
        for (double d : numbers) {
            osszeg += d;
        }
        return Math.round(osszeg);
    }

    public double sumAfterRound(double[] numbers) {
        double osszeg = 0;
        for (double d : numbers) {
            osszeg += Math.round(d);
        }
        return osszeg;
    }

    public double difference(int size,double max, int scale) {
        double[] d = randomNumbers(size, max, scale);
        double d1 = roundAfterSum(d);
        double d2 = sumAfterRound(d);
        return Math.abs(d1 - d2);
    }

    public static void main(String[] args) {
        RoundingAnomaly r = new RoundingAnomaly();
        double osszeg = 0;
        for (int i = 0; i < 100; i++) {
            double kulonbseg = r.difference(1000, 1000000, 5);
            osszeg += kulonbseg;
            System.out.println(kulonbseg);
        }
        System.out.println(osszeg / 100);
    }
}
