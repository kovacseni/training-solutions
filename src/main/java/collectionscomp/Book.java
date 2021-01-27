package collectionscomp;

public class Book implements Comparable<Book> {

    private int regNumber;
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public Book(int regNumber, String title, String author) {
        this(title, author);
        this.regNumber = regNumber;
    }

    public int getRegNumber() {
        return regNumber;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return regNumber + " " + title + " " + author;
    }

    @Override
    public int compareTo(Book book) {
        return this.title.compareTo(book.title);
    }
}
