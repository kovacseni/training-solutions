package week15d04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.*;

public class CoronaData {

    public List<Data> getThreeLargest(Reader reader) {
        List<Data> cases = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(reader)) {
            String line;
            while ((line = br.readLine()) != null) {
                getList(line, cases);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file.", ioe);
        }
        List<Data> hungarysThreeLargest = new ArrayList<>();
        hungarysThreeLargest.add(cases.get(0));
        hungarysThreeLargest.add(cases.get(1));
        hungarysThreeLargest.add(cases.get(2));

        return hungarysThreeLargest;
    }

    private List<Data> getList(String line, List<Data> hungarysCases) {
        if (line.contains("Hungary")) {
            String[] temp = line.split(",");
            String yearAndWeek = temp[1];
            int cases = Integer.parseInt(temp[2]);
            hungarysCases.add(new Data(yearAndWeek, cases));
        }
        Collections.sort(hungarysCases);
        Collections.reverse(hungarysCases);
        return hungarysCases;
    }
}
