package week13d03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BooksTest {

    private Books books = new Books();

    @BeforeEach
    public void setUp() {
        books.putToMap(new Book("Molnár Ferenc", "A Pál utcai fiúk", 208));
        books.putToMap(new Book("Gárdonyi Géza", "Egri csillagok", 647));
        books.putToMap(new Book("Gárdonyi Géza", "Ida regénye", 464));
        books.putToMap(new Book("Fekete István", "Tüskevár", 290));
        books.putToMap(new Book("Fekete István", "21 nap", 70));
    }

    @Test
    public void testGetAuthorWithMostPages() {
        Assertions.assertEquals("Gárdonyi Géza", books.getAuthorWithMostPages());
    }
}
