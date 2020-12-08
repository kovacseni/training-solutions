package objectclass;

import java.util.ArrayList;
import java.util.List;

public class SimpleBag {

    private int  cursor = -1;
    private List<Object> items;

    public SimpleBag() {
        this.items = new ArrayList<>();
    }

    public void putItem(Object item) {
        items.add(item);
    }

    public boolean isEmpty() {
        return items.size() == 0;
    }

    public int size() {
        return items.size();
    }

    public void beforeFirst() {
        cursor = -1;
    }

    public boolean hasNext() {
        return cursor < items.size() - 1;
    }

    public Object next() {
        cursor = cursor + 1;
        return items.get(cursor);
    }

    public boolean contains (Object item) {
        boolean contains = false;
        for (Object o : items) {
            if (o.equals(item)) {
                contains = true;
            }
        }
        return contains;
    }

    public  int getCursor() {
        return cursor;
    }
}
