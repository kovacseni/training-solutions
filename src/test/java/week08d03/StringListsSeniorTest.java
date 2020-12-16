package week08d03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class StringListsSeniorTest {

    @Test
    public void testMethod() {
        List<String> words = Arrays.asList("aaa", "aa", "bb", "cccc", "dd");
        List<String> shortest = Arrays.asList("aa", "bb", "dd");

        Assertions.assertEquals(shortest, new StringListsSenior().shortestWords(words));
    }
}
