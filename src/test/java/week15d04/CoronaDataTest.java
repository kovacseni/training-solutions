package week15d04;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class CoronaDataTest {

    private CoronaData cd = new CoronaData();

    @Test
    public void testThreeLargest() throws IOException {
        InputStream is = CoronaDataTest.class.getResourceAsStream("/coronadata.csv");
        InputStreamReader isr = new InputStreamReader(is);
        List<Data> three = cd.getThreeLargest(isr);

        Assertions.assertEquals(3, three.size());
        Assertions.assertEquals("2020-48", three.get(0).getYearAndWeek());
        Assertions.assertEquals("2020-49", three.get(1).getYearAndWeek());
        Assertions.assertEquals("2020-46", three.get(2).getYearAndWeek());
    }
}
