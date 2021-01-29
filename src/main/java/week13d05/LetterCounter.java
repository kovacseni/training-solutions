package week13d05;

import java.util.Set;
import java.util.TreeSet;

public class LetterCounter {

    public int countDifferentLetters(String word) {
       Set<Character> differentLetters = new TreeSet<>();
       char[] lettersOfWord = word.toCharArray();
       for (char c : lettersOfWord) {
           if (c >= 'a' && c <= 'z') {
               differentLetters.add(c);
           }
       }
       return differentLetters.size();
    }
}
