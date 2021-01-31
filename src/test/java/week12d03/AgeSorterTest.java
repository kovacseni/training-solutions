package week12d03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AgeSorterTest {

    @Test
    public void testSortAges() {
        int[] ages = new int[] {2, 7, 4, 3, 1, 6, 5};
        int[] expected = new int[] {1, 2, 3, 4, 5, 6, 7};
        AgeSorter as = new AgeSorter();
        Assertions.assertArrayEquals(expected, as.sortAges(ages));
    }
}
