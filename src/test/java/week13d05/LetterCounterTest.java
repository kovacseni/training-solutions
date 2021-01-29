package week13d05;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LetterCounterTest {

    @Test
    public void testCountDifferentLetters() {
        Assertions.assertEquals(6, new LetterCounter().countDifferentLetters("gólkirály"));
        Assertions.assertEquals(17, new LetterCounter().countDifferentLetters("A tájképi rendeletet tegnap 13-an elolvasták, ma 14-en megszavazták."));
    }
}
