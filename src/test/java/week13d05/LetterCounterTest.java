package week13d05;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LetterCounterTest {

    @Test
    public void testCountDifferentLetters() {
        Assertions.assertEquals(6, new LetterCounter().countDifferentLetters("gólkirály"));
        Assertions.assertEquals(17, new LetterCounter().countDifferentLetters("A tájképi rendeletet tegnap 13-an elolvasták, ma 14-en megszavazták."));
    }

    @Test
    public void testCountLetters() {
        Assertions.assertEquals("[a=3, b=1, e=1, f=1, g=1, l=3, m=1, o=1, r=1, v=1]", new LetterCounter().countLetters("Almafa-, Levélbogár").entrySet().toString());
    }
}
