package week08d04;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStreamReader;
import java.util.List;

public class ExamplesStoreTest {

    @Test
    public void testExamplesStore() {
        InputStreamReader isr = new InputStreamReader(ExamplesStoreTest.class.getResourceAsStream("/examples.md"));
        List<String> titles = new ExamplesStore().getTitlesOfExamples(isr);

        Assertions.assertEquals(2, titles.size());
        Assertions.assertEquals("Első feladat", titles.get(0));
        Assertions.assertEquals("Második feladat", titles.get(1));
    }
}
