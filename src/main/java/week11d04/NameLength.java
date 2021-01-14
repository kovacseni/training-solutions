package week11d04;

import java.util.ArrayList;
import java.util.List;

public class NameLength {

    public int[] getLengths(List<String> names) {
        List<String> namesWithJ = new ArrayList<>();
        for (String s : names) {
            if (s.startsWith("J")) {
                namesWithJ.add(s);
            }
        }
        List<Integer> lengthsList = new ArrayList<>();
        for (String s : namesWithJ) {
            if (!lengthsList.contains(s.length())) {
                lengthsList.add(s.length());
            }
        }
        int[] lengths = new int[lengthsList.size()];
        for (int i = 0; i < lengths.length; i++) {
            lengths[i] = lengthsList.get(i);
        }
        return lengths;
    }
}
