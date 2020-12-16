package week08d03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class StringListsTest {

    @Test
    public void testUnio() {
        List<String> first = Arrays.asList("a", "b", "c");
        List<String> second = Arrays.asList("a", "d");
        List<String> result = Arrays.asList("a", "b", "c", "d");

        Assertions.assertEquals(result, new StringLists().stringListsUnion(first, second));
    }

    @Test
    public void testUnio2() {
        List<String> first = Arrays.asList("alfa", "béta", "gamma");
        List<String> second = Arrays.asList("Alfa", "béta", "gamma", "Delta");
        List<String> result = Arrays.asList("alfa", "béta", "gamma", "Alfa", "Delta");

        Assertions.assertEquals(result, new StringLists().stringListsUnion(first, second));
    }
}
