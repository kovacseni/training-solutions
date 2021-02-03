package lambdastreams.bookstore;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BookStore {

    private List<Book> books;

    public BookStore(List<Book> books) {
        this.books =books;
    }

    public int getNumberOfBooks() {
        return (int)books.stream().reduce(0, (a, b) -> a + b.getPieces(), (x, y) -> x + y);
    }

    public Optional<Book> findNewestBook() {
        return books.stream().max(Comparator.comparingInt(Book::getYearOfPublish));
    }

    public int getTotalValue() {
        return books.stream().reduce(0, (a, b) -> a + b.getPrice() * b.getPieces(), (x, y) -> x + y);
    }

    public List<Book> getByYearOfPublish(int year) {
        return books.stream().collect(Collectors.groupingBy(Book::getYearOfPublish)).get(year);
    }
}
