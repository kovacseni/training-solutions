package week08d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class CountryStatistics2 {

    private List<Country> countries = new ArrayList<>();

    public List<Country> getCountries() {
        return new ArrayList<>(countries);
    }

    public void readFromFile(Reader reader) {
        try (BufferedReader br = new BufferedReader(reader)) {
            String line;
            while((line = br.readLine()) != null) {
                String[] temp = line.split(" ");
                countries.add(new Country(temp[0], Integer.parseInt(temp[1]), Integer.parseInt(temp[2]), Integer.parseInt(temp[3])));
            }
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Can not read file.", ioe);
        }
    }

    public Country maxPopulation() {
        Country result = countries.get(0);
        for (Country c : countries) {
            if (c.getPopulation() > result.getPopulation()) {
                result = c;
            }
        }
        return result;
    }
}
