package week08d03;

import java.util.ArrayList;
import java.util.List;

public class StringListsSenior {

    public List<String> shortestWords(List<String> words) {
        List<String> shortestList = new ArrayList<>();
        int min = words.get(0).length();
        for (String s : words) {
            if (s.length() < min) {
                min = s.length();
            }
        }
        for (String s : words) {
            if (s.length() == min) {
                shortestList.add(s);
            }
        }
        return shortestList;
    }
}
