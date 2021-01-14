package week11d04;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class NamesLengthTest {

    @Test
    public void testNameLength() {
        List<String> names = Arrays.asList("Joe", "Jane", "Jack", "Jake", "George", "William");
        int[] lengths = new int[] {3, 4};
        Assertions.assertArrayEquals(lengths, new NameLength().getLengths(names));
    }
}
