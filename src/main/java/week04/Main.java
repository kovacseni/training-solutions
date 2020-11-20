package week04;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Main m = new Main();
        System.out.println(m.getIndexesOfChar("ketchup", 'e'));
        System.out.println(m.getIndexesOfChar("kefe", 'e'));
        System.out.println(m.getIndexesOfChar("fekete kefe", 'e'));

    }

    List<Integer> getIndexesOfChar(String str, char c) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c) {
                result.add(i);
            }
        }

        return result;
    }
}

