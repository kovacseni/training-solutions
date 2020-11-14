package controliteration.pi;

import java.util.Arrays;
import java.util.List;

public class PiGenerator {

    public String getPi() {
        String piVers = "Nem a régi s durva közelítés, mi szótól szóig így kijön betűiket számlálva. Ludolph eredménye már, ha itt végezzük húsz jegyen. De rendre kijő még tíz pontosan, Azt is bízvást ígérhetem.";

        String pi = "";
        int betukSzama = 0;
        for (int i = 0; i < piVers.length(); i++) {
            if (betukSzama != 0 && !Character.isAlphabetic(piVers.charAt(i))) {
                pi = pi + betukSzama;
                if (pi.length() == 1) {
                    pi = pi + ".";
                }
                betukSzama = 0;
            }
            if (Character.isAlphabetic(piVers.charAt(i))) {
                betukSzama++;
            }
        }
        return pi;
    }

}
