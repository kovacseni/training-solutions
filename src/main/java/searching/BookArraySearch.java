package searching;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BookArraySearch {

    private Book[] bookArray;

    public BookArraySearch(Book[] bookArray) {
        this.bookArray = bookArray;
    }

    public Book findBookByAuthorTitle(String author, String title) {
        if (author == null || title == null || author.isBlank() || title.isBlank()) {
            throw new IllegalArgumentException("Author or title must not be empty!");
        }

        List<Book> books = new ArrayList<>();
        for (Book b :bookArray) {
            books.add(b);
        }
        Collections.sort(books);
        Book book = new Book(author, title);
        int result = Collections.binarySearch(books, book);
        if (result < 0) {
            throw new IllegalArgumentException("No book found by " + author + " with title " + title);
        }

        return books.get(result);
    }
}
