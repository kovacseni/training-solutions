package week14d05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

public class Hachiko {

    public Map<String, Integer> countWords(Reader reader, String... words) {
        try (BufferedReader br = new BufferedReader(reader)) {
            int[] sums = new int[words.length];
            String line;
            while ((line = br.readLine()) != null) {
                sums = count(line, sums, words);
            }
            return putInTheMap(sums, words);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file.", ioe);
        }
    }

    private int[] count(String line, int[] sums, String... words) {
        for (int i = 0; i < words.length; i++) {
            if (line.toLowerCase().contains(words[i].toLowerCase())) {
                sums[i] += 1;
            }
        }
        return sums;
    }

    private Map<String, Integer> putInTheMap(int[] sums, String... words) {
        Map<String, Integer> wordsSum = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            wordsSum.put(words[i], sums[i]);
        }
        return wordsSum;
    }
}
