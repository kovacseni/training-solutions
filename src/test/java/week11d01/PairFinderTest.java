package week11d01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PairFinderTest {

    @Test
    public void testPairFinder() {
        Assertions.assertEquals(4, new PairFinder().findPairs(new int[] {1, 2, 3, 4, 1, 2, 5, 5, 6, 5, 7, 5, 2}));
    }
}
