package collectionsequalshash;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BookCatalog {

    public Book findBookByTitleAuthor(List<Book> books, String title, String author) {
        for (Book b : books) {
            if (b.getTitle().equals(title) && b.getAuthor().equals(author)) {
                return b;
            }
        }
        return null;
    }

    public Book findBook(List<Book> books, Book book) {
        for (Book b : books) {
            if (b.getTitle().equals(book.getTitle()) && b.getAuthor().equals(book.getAuthor())) {
                return b;
            }
        }
        return null;
    }

    public Set<Book> addBooksToSet(Book[] bookArray) {
        Set<Book> books = new HashSet<>();
        for (Book b : bookArray) {
            books.add(b);
        }
        return books;
    }
}
