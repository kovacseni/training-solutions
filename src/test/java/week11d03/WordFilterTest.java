package week11d03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class WordFilterTest {

    @Test
    public void testWordFilter() {
        List<String> words = Arrays.asList("alma", "körte", "barack", "szilva", "ribizli", "kivi", "málna");
        List<String> result = Arrays.asList("alma", "barack", "szilva", "málna");

        Assertions.assertEquals(result, new WordFilter().wordsWithChar(words, 'a'));
    }
}
