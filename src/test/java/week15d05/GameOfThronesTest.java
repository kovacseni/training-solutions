package week15d05;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.InputStreamReader;

public class GameOfThronesTest {

    @Test
    public void testFamilyWithMostBattles() {
        GameOfThrones g = new GameOfThrones();
        InputStream is = GameOfThrones.class.getResourceAsStream("/battles.csv");
        InputStreamReader isr = new InputStreamReader(is);

        Assertions.assertEquals("Lannister", g.getFamilyWithMostBattles(isr));
    }
}
