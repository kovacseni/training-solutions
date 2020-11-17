package filescanner.library;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LibraryTest {

    @Test
    public void testLoadFromFile() {
        Library library = new Library();

        library.loadFromFile();

        assertEquals(6, library.getBooks().size());
        assertEquals("Bartos Erika", library.getBooks().get(5).getAuthor());
    }
}
