package week06d01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SeparatedSumTest {

    private String numberString;

    @BeforeEach
    public void setUp() {
        numberString = "12,13;-14,15;-15,16;16,17;-20,18;18,19";
    }

    @Test
    public void sumNumbers() {
        Assertions.assertEquals("A pozitív számok összege: 46.49, a negatív számok összege: -49.49", new SeparatedSum().separateStringAndSum(numberString));
    }

    @Test
    public void throwExceptionIfNumberStringIsEmpty() throws IllegalArgumentException {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new SeparatedSum().separateStringAndSum(null);
        });
        assertEquals("Nem értelmezhető számsor!", ex.getMessage());
    }
}
