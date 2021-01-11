package exceptions.polinom;

public class Polynomial {

    private double[] coefficients;

    public Polynomial(double[] coefficients) {
        if (coefficients == null) {
            throw new NullPointerException("coefficients is null");
        }
        this.coefficients = coefficients;
    }

    public Polynomial(String[] coefficientStr) {
        if (coefficientStr == null) {
            throw new NullPointerException("coefficientStrs is null");
        }
        try {
            this.coefficients = convert(coefficientStr);
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("Illegal coefficients, not a number", nfe);
        }
    }

    public double[] getCoefficients() {
        return coefficients;
    }

    public double evaluate(double x) {
        double sum = 0;
        for (int i = coefficients.length - 1; i >= 0; i--) {
            sum += coefficients[i] * Math.pow(x, ((double)coefficients.length - 1) - i);
        }
        return sum;
    }

    private double[] convert(String[] coefficientStr) {
        double[] coefficients = new double[coefficientStr.length];
        for (int i = 0; i < coefficientStr.length; i++) {
            double coefficient = Double.parseDouble(coefficientStr[i]);
            coefficients[i] = coefficient;
        }
        return coefficients;
    }
}
