package exceptionmulticatch.converter;

import java.util.Arrays;

public class BinaryStringConverter {

    public boolean[] binaryStringToBooleanArray(String str) {
        if (str == null) {
            throw new NullPointerException("binaryString null");
        }
            char[] stringElements = str.toCharArray();
            boolean[] booleanArray = new boolean[stringElements.length];
            for (int i = 0; i < stringElements.length; i++) {
                if (stringElements[i] == '0') {
                    booleanArray[i] = false;
                } else if (stringElements[i] == '1') {
                    booleanArray[i] = true;
                } else {
                    throw new IllegalArgumentException("binaryString not valid");
                }
            }
            return booleanArray;
    }

    public String booleanArrayToBinaryString(boolean[] booleanArray) {
        if (booleanArray.length == 0) {
            throw new IllegalArgumentException("Invalid array!");
        }
        String result = "";
        for (int i = 0; i < booleanArray.length; i++) {
            if (booleanArray[i] == false) {
                result += "0";
            } else if (booleanArray[i] == true) {
                result += "1";
            }
        }
        return result;
    }


}
