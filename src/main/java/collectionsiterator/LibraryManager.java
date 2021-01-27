package collectionsiterator;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class LibraryManager {

    private Set<Book> books;

    public LibraryManager(Set<Book> books) {
        this.books = books;
    }

    public int libraryBooksCount() {
        return books.size();
    }

    public Book findBookByRegNumber(int regNumber) {
        for (Iterator<Book> i = books.iterator(); i.hasNext();) {
            Book b = i.next();
            if (b.getRegNumber() == regNumber) {
                return b;
            }
        }
        throw new MissingBookException("No books found with regnumber: " + regNumber);
    }

    public int removeBookByRegNumber(int regNumber) {
        for (Iterator<Book> i = books.iterator(); i.hasNext();) {
            Book b = i.next();
            if (b.getRegNumber() == regNumber) {
                i.remove();
                return b.getRegNumber();
            }
        }
        throw new MissingBookException("No books found with regnumber: " + regNumber);
    }

    public Set<Book> selectBooksByAuthor(String author) {
        Set<Book> booksByAuthor = new HashSet<>();
        boolean isAuthor = false;
        for (Iterator<Book> i = books.iterator(); i.hasNext();) {
            Book b = i.next();
            if (b.getAuthor().equals(author)) {
                isAuthor = true;
                booksByAuthor.add(b);
            }
        }
        if (!isAuthor) {
            throw new MissingBookException("No books found by " + author);
        }
        return booksByAuthor;
    }
}
