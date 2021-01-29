package week12d02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class UtcaTest {

    @TempDir
    public File folder;

    @Test
    public void testUtca1() {
        Utca utca = new Utca();
        Path path1 = Path.of("src/main/resources/kerites.txt");
        utca.readSitesFromFile(path1);
        Path path2 = new File(folder, "ptlan.txt").toPath();
        utca.writeStreetOdd(path2);
        List<String> utcakep;
        try {
            utcakep = Files.readAllLines(path2);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file.", ioe);
        }

        Assertions.assertEquals("(1)KKKKKKKK", utcakep.get(0));
        Assertions.assertEquals("(3)::::::::::", utcakep.get(1));
        Assertions.assertEquals("(5)SSSSSSSSS", utcakep.get(2));
        Assertions.assertEquals("(7)KKKKKKKKKKKKKKKK", utcakep.get(3));
        Assertions.assertEquals("(9)#########", utcakep.get(4));
    }

    @Test
    public void testUtca2() {
        Utca utca = new Utca();
        Path path1 = Path.of("src/main/resources/kerites.txt");
        utca.readSitesFromFile(path1);
        List<Telek> list = utca.sortList();

        Assertions.assertEquals(8, list.get(0).getLength());
        Assertions.assertEquals(9, list.get(1).getLength());
        Assertions.assertEquals(9, list.get(2).getLength());
        Assertions.assertEquals(10, list.get(3).getLength());
        Assertions.assertEquals(10, list.get(4).getLength());
        Assertions.assertEquals(10, list.get(5).getLength());
        Assertions.assertEquals(12, list.get(6).getLength());
        Assertions.assertEquals(13, list.get(7).getLength());
        Assertions.assertEquals(13, list.get(8).getLength());
        Assertions.assertEquals(14, list.get(9).getLength());
        Assertions.assertEquals(16, list.get(10).getLength());
    }
}
