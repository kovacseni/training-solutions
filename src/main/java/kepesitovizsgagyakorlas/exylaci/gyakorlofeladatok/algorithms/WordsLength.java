package kepesitovizsgagyakorlas.exylaci.gyakorlofeladatok.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordsLength {

    public Map<Integer, Integer> getStatistic(String... text) {
        if (text == null) {
            throw new IllegalArgumentException("The parameter is a must!");
        }
        Map<Integer, Integer> statistic = new HashMap<>();
        List<String> words = getAllWordsInAList(text);
        for (String s : words) {
            int wordLength = s.length();
            if (!statistic.containsKey(wordLength)) {
                statistic.put(wordLength, 0);
            }
            statistic.put(wordLength, statistic.get(wordLength) + 1);
        }
        return statistic;
    }

    private List<String> getAllWordsInAList(String[] textArray) {
        List<String> words = new ArrayList<>();
        for (String s : textArray) {
            addWords(s, words);
        }
        return words;
    }

    private void addWords(String s, List<String> words) {
        if (s != null) {
            s = s.trim();
            String[] parts = s.split(" ");
            for (String str : parts) {
                int firstIndex = getFirstIndex(str);
                addNormalWords(words, str, firstIndex);
            }
        }
    }

    private int getFirstIndex(String str) {
        str = str.trim();
        char[] charsOfString = str.toCharArray();
        for (int i = 0; i < charsOfString.length; i++) {
            if (Character.isLetter(charsOfString[i])) {
                return i;
            }
        }
        return -1;
    }

    private void addNormalWords(List<String> words, String str, int firstIndex) {
        if (firstIndex >= 0) {
            int lastIndex = getLastIndex(str);
            words.add(str.substring(firstIndex, lastIndex + 1));
        }
    }

    private int getLastIndex(String str) {
        char[] charsOfString = str.toCharArray();
        for (int i = charsOfString.length - 1; i >= 0; i--) {
            if (Character.isLetter(charsOfString[i])) {
                return i;
            }
        }
        return -1;
    }
}
