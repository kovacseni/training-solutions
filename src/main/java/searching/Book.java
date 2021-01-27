package searching;

public class Book implements Comparable<Book> {

    private int id;
    private String author;
    private String title;

    public Book(int id, String author, String title) {
        if (author == null || title == null || author.isBlank() || title.isBlank()) {
            throw new IllegalArgumentException("Author or title must not be empty!");
        }
        this.id = id;
        this.author = author;
        this.title = title;
    }

    public Book(String author, String title) {
        if (author == null || title == null || author.isBlank() || title.isBlank()) {
            throw new IllegalArgumentException("Author or title must not be empty!");
        }
        this.author = author;
        this.title = title;
    }


    public int getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return id + " " + author + " " + title;
    }

    @Override
    public int compareTo(Book book) {
        if (author.compareTo(book.author) != 0) {
            return author.compareTo(book.author);
        } else {
            return title.compareTo(book.title);
        }
    }
}
