package week07d02;

public class DigitSum {

    public int sumOfDigits(int x) {
        String digit = Integer.toString(x);
        int sum = 0;

        for (int i = 0; i < digit.length(); i++) {
            sum += (Integer.parseInt(digit.substring(i, i+1)));
        }
        return sum;
    }
}
