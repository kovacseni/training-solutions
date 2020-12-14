package week08d01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RobotTest {

    @Test
    public void testMove() {
        Assertions.assertEquals(4, new Robot().move("BJJJJJLFFFF").getX());
        Assertions.assertEquals(3, new Robot().move("BJJJJJLFFFF").getY());
        Assertions.assertEquals(5, new Robot().move("BJJJJJLFFFF").getDistance());
    }

    @Test
    public void testMoveIllegalParameter() throws IllegalArgumentException {
        Exception ex = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Robot().move("JJGBBLLF");
        });
        assertEquals("Invalid move!", ex.getMessage());
    }
}
