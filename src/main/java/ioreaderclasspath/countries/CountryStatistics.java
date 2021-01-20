package ioreaderclasspath.countries;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CountryStatistics {

    private List<Country> countries = new ArrayList<>();

    public List<Country> getCountryList() {
        return new ArrayList<>(countries);
    }

    public void readFromFile(String filename) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(CountryStatistics.class.getResourceAsStream("/" + filename)))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] splittedLine = line.split(" ");
                countries.add(new Country(splittedLine[0], Integer.parseInt(splittedLine[1])));
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file.", ioe);
        }
    }

    public int numberOFCountries() {
        return countries.size();
    }

    public Country mostBorderCountries() {
        int most = countries.get(0).getBorderCountries();
        Country mostBorderCountriesCountry = null;
        for (Country c : countries) {
            if (c.getBorderCountries() > most) {
                most = c.getBorderCountries();
                mostBorderCountriesCountry = c;
            }
        }
        return mostBorderCountriesCountry;
    }
}
