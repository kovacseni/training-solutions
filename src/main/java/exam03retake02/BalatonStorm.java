package exam03retake02;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.Collator;
import java.util.*;

public class BalatonStorm {

    public List<String> getStationsInStorm(BufferedReader reader) throws IOException {
        List<String> stationsInStorm = new ArrayList<>();
        String station = "";
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.contains("allomas")) {
                String[] temp = line.split(": ");
                String name = temp[1];
                station = name.substring(1, name.length() - 2);
            }
            if (line.contains("level\": 3")) {
                stationsInStorm.add(station);
            }

        }
        stationsInStorm.sort(Collator.getInstance(new Locale("hu", "HU")));
        return stationsInStorm;
    }
}
