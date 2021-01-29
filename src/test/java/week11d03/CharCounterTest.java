package week11d03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CharCounterTest {

    @Test
    public void testCharCounter() {
        String[] chars = new String[] {"abc", "cba", "ab", "jklbzau", "jrlaghub"};

        Assertions.assertEquals(2, new CharCounter().countChars(chars));
    }

    @Test
    public void testCharCounter2() {
        String[] chars = new String[] {"abc", "cba", "ab", "jklbzau", "jrlaghub"};

        Assertions.assertEquals(2, new CharCounter2().countChars(chars));
    }
}
