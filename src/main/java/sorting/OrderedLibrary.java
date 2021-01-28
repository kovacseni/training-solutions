package sorting;

import java.util.Set;

public class OrderedLibrary {

    private Set<Book> books;

    public OrderedLibrary(Set<Book> books) {
        this.books = books;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public Book lendFirstBook() {
        if (books == null || books.isEmpty()) {
            throw new NullPointerException("Library is empty!");
        }
        Book first = new Book(99999, "XY", "xy");
        for (Book b : books) {
            if (b.compareTo(first) < 0) {
                first = b;
            }
        }
        return first;
    }
}
