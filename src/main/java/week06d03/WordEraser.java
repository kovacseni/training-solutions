package week06d03;

import java.util.ArrayList;
import java.util.List;

public class WordEraser {

    public String eraseWord(String words, String word) {
        String[] splittedWords = words.split(" ");
        List<String> list = new ArrayList<>();

        for (String s : splittedWords) {
            if (!s.equals(word)) {
               list.add(s);
            }
        }

        String resultString = "";
        for (String s : list) {
            resultString += s + " ";
        }
        resultString =resultString.trim();
        return resultString;
    }
}
