package week08d05;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;

public class PlaneTest {

    @Test
    public void testPlaneOcean() {
        Plane plane = new Plane();
        Path path = Path.of("src/main/resources/map.txt");

        Assertions.assertEquals(16, plane.getLongestOcean(path));
    }

    @Test
    public void testPlaneEarth() {
        Plane plane = new Plane();
        Path path = Path.of("src/main/resources/map.txt");

        Assertions.assertEquals(10, plane.getLongestEarth(path));
    }
}
