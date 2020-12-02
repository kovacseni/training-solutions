package methodparam.measuring;

public class Measurement {

    private double[] measureResults;

    public Measurement(double[] measureResults) {
        this.measureResults = measureResults;
    }

    public int findFirstIndexInLimit(int lower, int upper) {
        int index = -1;
        for (int i = 0; i < measureResults.length; i++) {
            if (measureResults[i] > lower && measureResults[i] < upper) {
                index = i;
                break;
            }
        }
        return index;
    }

    public double minimum() {
        double min = measureResults[1];
        for (double d : measureResults) {
            if (d < min) {
                min = d;
            }
        }
        return min;
    }

    public double maximum() {
        double max = measureResults[1];
        for (double d : measureResults) {
            if (d > max) {
                max = d;
            }
        }
        return max;
    }

    public ExtremValues minmax() {
        double min = minimum();
        double max = maximum();

        return new ExtremValues(min, max);
    }
}
