package collectionsclass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionManager {

    private List<Book> library;

    public CollectionManager(List<Book> library) {
        this.library = library;
    }

    public List<Book> getLibrary() {
        return new ArrayList<>(library);
    }

    public List<Book> createUnmodifiableLibrary() {
        return Collections.unmodifiableList(library);
    }

    public List<Book> reverseLibrary(){
        List<Book> reverse = getLibrary();
        Collections.reverse(reverse);
        return reverse;
    }

    public Book getFirstBook() {
        List<Book> ordered = getOrderedList();
        return ordered.get(0);
    }

    public Book getLastBook() {
        List<Book> ordered = getOrderedList();
        return ordered.get(ordered.size() - 1);
    }

    private List<Book> getOrderedList() {
        List<Book> ordered = getLibrary();
        Collections.sort(ordered, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.compareTo(o2);
            }
        });
        return ordered;
    }
}
