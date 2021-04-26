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
        if (text.length == 1 && "".equals(text[0])) {
            return new HashMap<>();
        }
        if (text.length == 1 && !"".equals(text[0])) {
            text = text[0].split(" ");
        }
        List<Integer> normalisedLengthOfWords = getNormalisedLengthOfWords(text);
        return getResult(normalisedLengthOfWords);
    }

    private List<Integer> getNormalisedLengthOfWords(String[] text) {
        List<Integer> normalisedLengthOfWords = new ArrayList<>();
        for (String s : text) {
            if (s != null && !s.isBlank()) {
                String[] parts = s.split(" ");
                for (String st : parts) {
                    char[] chars = st.toCharArray();
                    int index1 = getIndexOfFirstLetter(chars);
                    int index2 = getIndexOfLastLetter(chars);
                    int number = index2 - index1;
                    normalisedLengthOfWords.add(number);
                }
            }
        }
        return normalisedLengthOfWords;
    }

    private int getIndexOfFirstLetter(char[] chars) {
        for (int i = 0; i < chars.length; i++) {
            if (Character.isLetter(chars[i])) {
                return i;
            }
        }
        throw new IllegalArgumentException("I said that you should give me a normal char array!");
    }

    private int getIndexOfLastLetter(char[] chars) {
        for (int i = chars.length - 1; i >= 0; i--) {
            if (Character.isLetter(chars[i])) {
                return i;
            }
        }
        throw new IllegalArgumentException("I said that you should give me a normal char array!");
    }

    /* Character.isLetter(chars[chars.length - 1]) ? chars.length : chars.length - 1;

    private int getCountOfLetters(char[] chars) {

        if ()
        return Character.isLetter(chars[chars.length - 1]) ? chars.length : chars.length - 1;
        /*int count = 0;
        for (char c : chars) {
            if (Character.isLetter(c)) {
                count++;
            }
        }
        return count;
    }*/

    private Map<Integer, Integer> getResult(List<Integer> normalisedLengthOfWords) {
        Map<Integer, Integer> statistic = new HashMap<>();
        for (int i : normalisedLengthOfWords) {
            if (!statistic.containsKey(i)) {
                statistic.put(i, 0);
            }
            statistic.put(i, statistic.get(i) + 1);
        }
        System.out.println(statistic);
        return statistic;
    }
}
