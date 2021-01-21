package iofilestest.library;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class LibraryTest {

    @TempDir
    public File folder;

    private Library library = new Library();

    @BeforeEach
    public void setUp() {
        library.add(new Book("Gárdonyi Géza", "Egri csillagok"), new Book("Molnár Ferenc", "A Pál utcai fiúk"), new Book("Fekete István", "Tüskevár"));
        library.add(new Book("Gárdonyi Géza", "Egri csillagok"));
    }

    @Test
    public void testSaveBooks() {
        Path path = new File(folder, "registry.txt").toPath();
        library.saveBooks(path);
        List<String> testRegistry = new ArrayList<>();
        try {
            testRegistry = Files.readAllLines(path);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read.", ioe);
        }

        Assertions.assertEquals(3, testRegistry.size());
        Assertions.assertEquals("Gárdonyi Géza: Egri csillagok", testRegistry.get(0));
        Assertions.assertEquals("Molnár Ferenc: A Pál utcai fiúk", testRegistry.get(1));
        Assertions.assertEquals("Fekete István: Tüskevár", testRegistry.get(2));
    }

    @Test
    public void testLoadBooks() {
        library.loadBooks(Path.of("src/main/resources/registry.txt"));

        Assertions.assertEquals(6, library.getRegistry().size());

        Assertions.assertEquals("Gárdonyi Géza", library.getRegistry().get(0).getAuthor());
        Assertions.assertEquals("Egri csillagok", library.getRegistry().get(0).getTitle());

        Assertions.assertEquals("Molnár Ferenc", library.getRegistry().get(1).getAuthor());
        Assertions.assertEquals("A Pál utcai fiúk", library.getRegistry().get(1).getTitle());

        Assertions.assertEquals("Fekete István", library.getRegistry().get(2).getAuthor());
        Assertions.assertEquals("Tüskevár", library.getRegistry().get(2).getTitle());

        Assertions.assertEquals("Fjodor Mihajlovics Dosztojevszkij", library.getRegistry().get(3).getAuthor());
        Assertions.assertEquals("Bűn és bűnhődés", library.getRegistry().get(3).getTitle());

        Assertions.assertEquals("Lev Nyikolajevics Tolsztoj", library.getRegistry().get(4).getAuthor());
        Assertions.assertEquals("Háború és béke", library.getRegistry().get(4).getTitle());

        Assertions.assertEquals("Valentyin Petrovics Katajev", library.getRegistry().get(5).getAuthor());
        Assertions.assertEquals("Távolban egy fehér vitorla", library.getRegistry().get(5).getTitle());
    }
}
