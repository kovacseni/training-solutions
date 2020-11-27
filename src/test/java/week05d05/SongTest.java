package week05d05;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SongTest {

    @Test
    public void songNameIsEmpty() throws IllegalArgumentException {
        Exception ex = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Song("", 329, "Metallica");
        });
        Assertions.assertEquals("Az előadó neve és a zeneszám címe nem maradhat üresen!", ex.getMessage());
    }

    @Test
    public void songArtistIsEmpty() throws IllegalArgumentException {
        Exception ex = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Song("Enter Sandman", 329, null);
        });
        Assertions.assertEquals("Az előadó neve és a zeneszám címe nem maradhat üresen!", ex.getMessage());
    }

    @Test
    public void songLengthIsBad() throws IllegalArgumentException {
        Exception ex = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Song("Enter Sandman", -5, "Metallica");
        });
        Assertions.assertEquals("A zeneszám hosszát meg kell adni!", ex.getMessage());
    }
}
