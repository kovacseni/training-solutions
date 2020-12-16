package week08d03;

import java.util.ArrayList;
import java.util.List;

public class StringLists {

    public List<String> stringListsUnion(List<String> first, List<String> second) {
        List<String> unio = new ArrayList<>();

        for (String s : first) {
            unio.add(s);
        }
        for (String s : second) {
            if (!unio.contains(s)) {
                unio.add(s);
            }
        }
        return unio;
    }
}
