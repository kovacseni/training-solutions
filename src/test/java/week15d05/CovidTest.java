package week15d05;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class CovidTest {

    @Test
    public void testGetThreeLargestCases() {
        InputStream is = Covid.class.getResourceAsStream("/coronadata.csv");
        InputStreamReader isr = new InputStreamReader(is);
        Covid covid = new Covid();
        covid.loadFromFile(isr);
        List<Country> expected = covid.getThreeLargestCases();

        Assertions.assertEquals(3, expected.size());
        Assertions.assertEquals("Andorra", expected.get(0).getName());
        Assertions.assertEquals("Gibraltar", expected.get(1).getName());
        Assertions.assertEquals("Montenegro", expected.get(2).getName());
    }
}
