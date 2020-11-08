package objects;

public class ObjectsMain {

    public static void main(String[] args) {
        new Book();

        /* Nem lehet hozzáférni. */

        System.out.println(new Book());

        /* Azt írja ki, hogy objects.Book@378bf509 */

        Book emptyBook = new Book();

        System.out.println(emptyBook);

        /* Azt írja ki, hogy objects.Book@5fd0d5ae */

        emptyBook = null;

        System.out.println(emptyBook);

        /* Kiírta, hogy null */

        Book book = new Book();

        book = new Book();

        System.out.println(book);

        /* Értéke: objects.Book@2d98a335 */

        Book anotherBook = new Book();

        boolean b = book == anotherBook;

        System.out.println(b);

        /* false */

        anotherBook = book;

        System.out.println(b);

        /* false */

        b = book == anotherBook;

        System.out.println(b);

        /* true */

        System.out.println(anotherBook instanceof Book);

        /* true */


        Book book1 = new Book();
        Book book2 = new Book();
        Book book3 = new Book();
        Book book4 = book1;
        Book book5 = book1;
        Book book6 = book3;
        Book book7 = null;
        book4 = book5;
        book5 = new Book();
        book6 = null;

        /* Ez a kód 4 objektumot hoz létre, a következő sorokban:

        Book book1 = new Book();
        Book book2 = new Book();
        Book book3 = new Book();
        book5 = new Book();

        Mind a négyhez hozzá lehet férni, mert értékül vannak adva egy változónak.

         */




    }
}
