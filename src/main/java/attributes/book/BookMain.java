package attributes.book;

public class BookMain {

    public static void main(String[] args) {
        Book book =new Book("Tüskevár");

        System.out.println(book.getTitle());

        book.setTitle("Keménykalap és krumpliorr");

        System.out.println(book.getTitle());

    }
}
