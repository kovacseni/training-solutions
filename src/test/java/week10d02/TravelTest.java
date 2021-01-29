package week10d02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class TravelTest {

    @Test
    public void testGetStopWithMax() {
        Travel travel = new Travel();
        Path path = Path.of("src/main/resources/utasadat.txt");
        try (InputStream is = Files.newInputStream(path)) {
            Assertions.assertEquals(0, travel.getStopWithMax(is));
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file.", ioe);
        }
    }
}
