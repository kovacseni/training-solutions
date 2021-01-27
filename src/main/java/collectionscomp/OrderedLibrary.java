package collectionscomp;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class OrderedLibrary {

    private List<Book> books;

    public OrderedLibrary(List<Book> books) {
        this.books = books;
    }

    public List<Book> getBooks() {
        return new ArrayList<>(books);
    }

    public List<Book> orderedByTitle() {
        List<Book> orderedBooks = new ArrayList<>(books);
        Collections.sort(orderedBooks);
        return orderedBooks;
    }

    public List<Book> orderedByAuthor() {
        List<Book> orderedBooks = new ArrayList<>(books);
        Collections.sort(orderedBooks, new AuthorComparator());
        return orderedBooks;
    }

    public List<String> orderedByTitleLocale(Locale locale) {
        List<String> orderedTitles = new ArrayList<>();
        for (Book b : books) {
            orderedTitles.add(b.getTitle());
        }
        Collator collator = Collator.getInstance(locale);
        Collections.sort(orderedTitles, collator);

        return orderedTitles;
    }
}
