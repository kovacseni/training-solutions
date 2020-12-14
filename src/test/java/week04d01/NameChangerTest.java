package week04d01;

import org.junit.jupiter.api.Test;
import week04d01.NameChanger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NameChangerTest {

    @Test

    public void konstruktorTeszt() throws IllegalArgumentException {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new NameChanger(null);
        });

        assertEquals("Invalid Name:<null>", ex.getMessage());

    }

    @Test
    public void changeFirstNameTest() {
        assertEquals("Kovács Antal", new NameChanger("Kovács Nóra").changeFirstName("Antal"));

    }
}
