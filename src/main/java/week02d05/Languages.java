package week02d05;

import java.util.ArrayList;
import java.util.List;

public class Languages {

    public static void main(String[] args) {

        List<String> programNyelvek = new ArrayList<>();
        programNyelvek.add("Java");
        programNyelvek.add("Python");
        programNyelvek.add("JavaScript");

        for (String otKarakter : programNyelvek) {
            if (otKarakter.length() > 5) {
                System.out.println(otKarakter);
            }
        }
    }
}
