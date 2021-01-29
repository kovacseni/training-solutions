package week13d05;

import java.util.*;

public class LetterCounter {

    public int countDifferentLetters(String word) {
       Set<Character> differentLetters = new TreeSet<>();
       char[] lettersOfWord = word.toLowerCase().toCharArray();
       for (char c : lettersOfWord) {
           if (c >= 'a' && c <= 'z') {
               differentLetters.add(c);
           }
       }
       return differentLetters.size();
    }

    public Map<Character, Integer> countLetters(String word) {
        Map<Character, Integer> lettersOfWord = new TreeMap<>();
        int[] keyAndValue = new int[2];
        char[] letters = word.toLowerCase().toCharArray();
        for (char c : letters) {
            if (c >= 'a' && c <= 'z') {
                keyAndValue = getKeyAndValue(c, lettersOfWord);
                lettersOfWord.put((char)keyAndValue[0], keyAndValue[1]);
            }
        }
        return lettersOfWord;
    }

    private int[] getKeyAndValue(char c, Map<Character, Integer> lettersOfWord) {
        int[] keyAndValue = new int[2];
        if (!lettersOfWord.containsKey(c)) {
            keyAndValue[0] = c;
            keyAndValue[1] = 1;
        }
        if (lettersOfWord.containsKey(c)) {
            int sum = lettersOfWord.get(c) + 1;
            keyAndValue[0] = c;
            keyAndValue[1] = sum;
        }
        return keyAndValue;
    }

    public static void main(String[] args) {
        LetterCounter lc = new LetterCounter();
        lc.countLetters("Almafa-, Levélbogár");
        System.out.println(lc.countLetters("Almafa-, Levélbogár").keySet().toString());
        System.out.println(lc.countLetters("Almafa-, Levélbogár").entrySet().toString());
    }
}
