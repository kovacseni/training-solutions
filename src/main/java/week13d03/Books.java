package week13d03;

import java.util.HashMap;
import java.util.Map;

public class Books {

    private Map<String, Integer> books = new HashMap<>();

    public void putToMap(Book book) {
        String author = book.getAuthor();
        int pages = book.getNumberOfPages();
        if (!books.containsKey(author)) {
            books.put(author, pages);
        } else {
            int allPages = books.get(author) + pages;
            books.put(author, allPages);
        }
    }

    public String getAuthorWithMostPages() {
        int maxPages = 0;
        String author = null;
        for (String s : books.keySet()) {
            if (books.get(s) > maxPages) {
                maxPages = books.get(s);
                author = s;
            }
        }
        return author;
    }
}
