package stringscanner;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class StringScanner {

   public boolean isEmpty(String s) {
        return s == null || s.equals("") || s.isBlank();
    }

    public int readAndSumValues(String intString, String delimiter) {
        if (delimiter == null && intString.contains(":")) {
            throw new IllegalArgumentException("Incorrect parameter string!");
        } else if (delimiter == null && intString.contains(":")) {
            delimiter = " ";
        }

        int i = 0;

       try (Scanner scanner = new Scanner(intString)) {
           if (intString.isEmpty()) {
               throw new IllegalArgumentException("Incorrect parameter string!");
           }
           if (!intString.contains(delimiter)) {
               throw new IllegalArgumentException("Incorrect parameter string!");
           }

        scanner.useDelimiter(delimiter);
        while (scanner.hasNext()) {
            i = i + scanner.nextInt();
        }
       } catch (InputMismatchException ime ) {
           throw new IllegalArgumentException("Incorrect parameter string!");
        }
       return i;
    }

    public int readAndSumValues(String intString) {
        return readAndSumValues(intString, null);
    }

    public String filterLinesWithWordOccurrences(String text, String word) {
        if (text.isEmpty() || word.isEmpty()) {
            throw new IllegalArgumentException("Incorrect parameter string!");
        }

        List<String> scannerList = new ArrayList<>();
        try (Scanner scanner = new Scanner(text)) {
            while (scanner.hasNextLine()) {
                String s = scanner.nextLine();
                if (s.contains(word)) {
                    scannerList.add(s);
                }
            }
        }
        return scannerList.toString();
    }

}


/* Tudom, hogy nem jó ez a feladat, de teljesen belezavarodtam. Valamint szerintem ellentmondás van a tesztesetek között.*/