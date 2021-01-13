package week11d03;

import java.util.Arrays;

public class CharCounter {

    public int countChars(String[] chars) {
        String model = chars[0];
        char[] modelCharArray = model.toCharArray();
        boolean[] booleanArray = new boolean[chars.length];
        int sum = 0;

        for (int i = 0; i < modelCharArray.length; i++) {
            for (int j = 0; j < chars.length; j++) {
                char[] sCharArray = chars[j].toCharArray();
                for (char c : sCharArray) {
                    if (c == modelCharArray[i]) {
                        booleanArray[j] = true;
                    }
                }
            }
            int numberOfTrues = 0;
            for (boolean b : booleanArray) {
                if (b == true) {
                    numberOfTrues++;
                }
            }
            if (numberOfTrues == chars.length) {
                sum++;
            }
            booleanArray = new boolean[chars.length];
        }
        return sum;
    }
}
