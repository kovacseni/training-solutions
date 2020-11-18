package stringscanner;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StringScanner {

   public boolean isEmpty(String s) {
        return s == null || s.equals("");
    }

    public int readAndSumValues(String intString, String delimiter) {
      Scanner scanner = new Scanner(intString);
      int sum = 0;

     try {
         if (isEmpty(delimiter)) {
             while (scanner.hasNext()) {
                 sum = sum + scanner.nextInt();
             }
         } else {
             while (scanner.hasNext()) {
                 sum = sum + scanner.useDelimiter(delimiter).nextInt();
             }
         }
     } catch (InputMismatchException imme) {
         throw new IllegalArgumentException("Incorrect parameter string!");
     }
      return sum;
    }

    public int readAndSumValues(String intString) {
        return readAndSumValues(intString, null);
    }

    public String filterLinesWithWordOccurrences(String text, String word) {
        if (isEmpty(text) || isEmpty(word) || text.isBlank()) {
            throw new IllegalArgumentException("Incorrect parameter string!");
        }

        Scanner scanner = new Scanner(text);
        String sum = "";
            while (scanner.hasNextLine()) {
                String s = scanner.nextLine();
                if (s.contains(word)) {
                    sum = sum.concat(s);
                    sum = sum.concat("\n");
                }
            }
            return sum.trim();
    }

}