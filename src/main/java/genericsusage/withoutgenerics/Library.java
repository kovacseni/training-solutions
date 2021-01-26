package genericsusage.withoutgenerics;

import genericsusage.Book;

import java.util.List;

public class Library {

    public Book getFirstBook(List books) {
        if (books.isEmpty()) {
            throw new IllegalArgumentException("Argument should not be empty!");
        }
        for (Object o : books) {
            if (!(o instanceof Book)) {
                throw new ClassCastException("Not a book");
            }
        }
        return (Book)books.get(0);
    }
}
