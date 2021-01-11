package week11d01;

public class DivisorFinder2 {

    public int findDivisors(int n) {
        n = Math.abs(n);
        int sum = 0;
        String number = Integer.toString(n);
        char[] xy = number.toCharArray();
        for (int i = 0; i < xy.length; i++) {
            int x = Character.getNumericValue(xy[i]);
            if (x > 0 && n % x == 0) {
                sum++;
            }
        }
        return sum;
    }
}
