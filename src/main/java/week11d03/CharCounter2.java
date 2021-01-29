package week11d03;

public class CharCounter2 {

    public int countChars(String[] chars) {
        char[] first = chars[0].toCharArray();
        int sum = 0;
        boolean isThere = true;
        for (char c : first) {
            for (String s : chars) {
                if (s.indexOf(c) < 0) {
                    isThere = false;
                }
            }
            if (isThere == true) {
                sum++;
            }
        }
        return sum;
    }
}
