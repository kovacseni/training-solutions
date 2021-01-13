package week11d03;

import java.util.ArrayList;
import java.util.List;

public class WordFilter {

    public List<String> wordsWithChar(List<String> words, char c) {
        List<String> result = new ArrayList<>();
        for (String s : words) {
            char[] stringCharArray = s.toCharArray();
            for (char ch : stringCharArray) {
                if (ch == c) {
                    result.add(s);
                    break;
                }
            }
        }
        return result;
    }
}
