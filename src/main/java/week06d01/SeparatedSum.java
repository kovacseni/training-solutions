package week06d01;

import java.util.ArrayList;
import java.util.List;

public class SeparatedSum {

    public String separateStringAndSum(String numberString) {
        if ("".equals(numberString) || numberString == null || numberString.isBlank()) {
            throw new IllegalArgumentException("Nem értelmezhető számsor!");
        }

        numberString = numberString.replace(",", ".");
        String[] splittedString = numberString.split(";");
        List<Double> positiveNumbers = new ArrayList<>();
        List<Double> negativeNumbers = new ArrayList<>();
        for (String s : splittedString) {
            if (s.startsWith("-")) {
                negativeNumbers.add(Double.parseDouble(s));
            } else {
                positiveNumbers.add(Double.parseDouble(s));
            }
        }

        double sumPositives = 0.0;
        for (double d : positiveNumbers) {
            sumPositives = sumPositives + d;
        }
        double sumNegatives = 0.0;
        for (double d : negativeNumbers) {
            sumNegatives = sumNegatives + d;
        }

       return "A pozitív számok összege: " + Double.toString(sumPositives).substring(0, 5) + ", a negatív számok összege: " + Double.toString(sumNegatives).substring(0, 6);
    }
}
