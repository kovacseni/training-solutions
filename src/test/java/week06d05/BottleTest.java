package week06d05;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BottleTest {

    @Test
    public void testNotFull() {
        Assertions.assertFalse(Bottle.of(BottleType.GLASS_BOTTLE).fill(3));
    }

    @Test
    public void testFull() throws IllegalArgumentException {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new Bottle(BottleType.PET_BOTTLE, 14).fill(2);
        });
        assertEquals("Ennyi folyadéktól túlcsordul az üveg!", ex.getMessage());
    }
}
