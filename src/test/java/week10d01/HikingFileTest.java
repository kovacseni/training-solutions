package week10d01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class HikingFileTest {

    @Test
    public void testGetPlusElevation() {
        Path path = Path.of("src/main/resources/gps.dat");
        try(InputStream is = Files.newInputStream(path)) {
            int[] upAndDown = new int[] {25, 15};
            Assertions.assertArrayEquals(upAndDown, new HikingFile().getPlusElevation(is));
        }catch(IOException ioe) {
            throw new IllegalStateException("Can not read file.", ioe);
        }
    }
}
