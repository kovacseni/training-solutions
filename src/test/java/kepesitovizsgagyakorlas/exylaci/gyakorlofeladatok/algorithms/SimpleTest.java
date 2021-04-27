package kepesitovizsgagyakorlas.exylaci.gyakorlofeladatok.algorithms;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions;

public class SimpleTest {

    private String s;
    private Integer i;

    @Test
    public void testMethodTextNotNull() {
        Assertions.assertEquals(false, new Simple().method("Szia!"));
    }

    @Test
    public void testMethodTextNull1() {
        String text = null;

        Assertions.assertEquals(true, new Simple().method(text));
    }

    @Test
    public void testMethodTextNull2() {
        Assertions.assertEquals(true, new Simple().method(s));
    }

    @Test
    public void testMethodIntegerNotNull() {
        Assertions.assertEquals(0, new Simple().method(3));
    }

    @Test
    public void testMethodIntegerNull1() {
        Integer number = null;

        Exception ex = Assertions.assertThrows(IllegalArgumentException.class, () -> new Simple().method(number));
        Assertions.assertEquals("Nem jó szám!", ex.getMessage());
    }

    @Test
    public void testMethodIntegerNull2() {
        Exception ex = Assertions.assertThrows(IllegalArgumentException.class, () -> new Simple().method(i));
        Assertions.assertEquals("Nem jó szám!", ex.getMessage());
    }
}