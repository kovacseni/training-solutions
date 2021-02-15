package week16d01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class VowelFilterTest {

    @Test
    public void testFilterVowels() throws IOException {
        Path path = Path.of("src/main/resources/macska.txt");
        BufferedReader reader = Files.newBufferedReader(path);
        Assertions.assertEquals("""
                prcsk
                Klpcsk
                Bnn
                Cscsk
                Mcsk
                Mcsk""", new VowelFilter().filterVowels(reader));
    }
}
