package finalmodifier;

import java.util.Arrays;
import java.util.List;

public class Week {

    public static final List<String> HET_NAPJAI = Arrays.asList("Hétfő", "Kedd", "Szerda", "Csütörtök", "Péntek", "Szombat", "Vasárnap");

    public static void main(String[] args) {


        System.out.println(HET_NAPJAI.toString());

        HET_NAPJAI.set(1, "más");

        System.out.println(HET_NAPJAI.toString());

    }

}
