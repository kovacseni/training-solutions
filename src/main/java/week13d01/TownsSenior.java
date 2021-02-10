package week13d01;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class TownsSenior {

    public TownSenior getFirstTownNameInAlphabet() {

        Path path = Path.of("src/main/resources/iranyitoszamok-varosok-2021.csv");
        try (BufferedReader br = Files.newBufferedReader(path)) {
            String line = br.readLine();
            TownSenior first = new TownSenior(line.split(";")[1], line.split(";")[0]);
            while ((line = br.readLine()) != null) {
                String[] temp = line.split(";");
                if (!getFirst(temp[1], first.getName()).equals(first.getName())) {
                    first = new TownSenior(temp[1], temp[0]);
                }
            }

            return first;

        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }

    private String getFirst(String townName, String first) {
        List<String> twoTowns = new ArrayList<>();
        twoTowns.add(townName);
        twoTowns.add(first);

        Locale locale = new Locale("hu", "HU");
        Collator collator = Collator.getInstance(locale);
        Collections.sort(twoTowns, collator);

        return twoTowns.get(0);
    }
}


    /*
    Mai Senior feladat:
A GitHubon a `examples\week13d01\src\main\resources\iranyitoszamok-varosok-2021.csv` fájl tartalmazza a magyar városok listáját.
Add vissza az ábécésorrendben első város nevét és irányítószámát!
     */
