package week05d03;

import java.util.ArrayList;
import java.util.List;

public class ListCounter {
    private List<String> list;

    public int count(List<String> list) {
        int i = 0;
        for (String s : list) {
            if (s.startsWith("a") || s.startsWith("A")) {
                i = i + 1;
            }
        }
        return i;
    }
}
