package week13d01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TownsSeniorTest {

    @Test
    public void testGetFirstTownNameInAlphabet() {
        Assertions.assertEquals("Aba", new TownsSenior().getFirstTownNameInAlphabet().getName());
        Assertions.assertEquals("8127", new TownsSenior().getFirstTownNameInAlphabet().getPostCode());
    }
}
