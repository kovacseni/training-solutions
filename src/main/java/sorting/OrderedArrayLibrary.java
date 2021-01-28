package sorting;

import java.util.Arrays;
import java.util.Comparator;

public class OrderedArrayLibrary {

    private Book[] bookArray;

    public OrderedArrayLibrary(Book[] bookArray) {
        this.bookArray = bookArray;
    }

    public Book[] getBookArray() {
        return bookArray;
    }

    public Book[] sortingById() {
        Book[] newBookArray = new Book[bookArray.length];
        for (int i = 0; i < bookArray.length; i++) {
            newBookArray[i] = bookArray[i];
        }
        Arrays.sort(newBookArray);
        return newBookArray;
    }

    public Book[] sortingByTitle() {
        Comparator<Book> comp = new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getTitle().compareTo(o2.getTitle());
            }
        };

        Book[] newBookArray = new Book[bookArray.length];
        for (int i = 0; i < bookArray.length; i++) {
            newBookArray[i] = bookArray[i];
        }
        Arrays.sort(newBookArray, comp);
        return newBookArray;
    }
}
