package week11d01;

public class DivisorFinder {

    public int findDivisors(int n) {
        n = Math.abs(n);
        int sum = 0;
        String number = Integer.toString(n);
        for (int i = 0; i < number.length(); i++) {
            int x = Integer.parseInt(number.substring(i, i+1));
            if (x > 0) {
                int y = n % x;
                if (y == 0) {
                    sum++;
                }
            }
        }
        return sum;
    }
}
