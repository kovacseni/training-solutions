package week05d02;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class changeLetterTest {

    @Test
    public void changeLetterTest() {
       assertEquals("*'m y**r w*f* *nd y** *r* my h*sb*nd.", new changeLetter().changeVowels("I'm your wife And yOU arE my husband."));
    }

    @Test
    public void changeLetterExceptionTest1() throws IllegalArgumentException {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new changeLetter().changeVowels("");
        });

        assertEquals("Empty string!", ex.getMessage());
    }

    @Test
    public void changeLetterExceptionTest2() throws IllegalArgumentException {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new changeLetter().changeVowels(null);
        });

        assertEquals("Empty string!", ex.getMessage());
    }
}
