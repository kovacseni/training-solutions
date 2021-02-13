package week15d05;

import java.io.*;
import java.util.*;

public class Covid {

    private Map<Country, Integer> covidData = new HashMap<>();

    public void loadFromFile(Reader reader) {
        try (BufferedReader br = new BufferedReader(reader)) {
            load(br);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file.", ioe);
        }
    }

    private void load(BufferedReader br) throws IOException {
        String line = br.readLine();
        Country country = new Country(null, 0);
        while ((line = br.readLine()) != null) {
            String[] temp = line.split(",");
            if (!temp[4].equals(country.getName())) {
                country = new Country(temp[4], Integer.parseInt(temp[7]));
                covidData.put(country, 0);
            }
            covidData.put(country, covidData.get(country) + Integer.parseInt(temp[2]));
        }
    }

    public List<Country> getThreeLargestCases() {
        List<Country> threeLargestCases = new ArrayList<>();
        List<Country> countries = new ArrayList<>();

        loadCountries(countries);
        countries.sort(Comparator.comparing(Country::getRate));
        Collections.reverse(countries);
        loadThreeLargestCases(countries, threeLargestCases);

        return threeLargestCases;
    }

    private void loadCountries(List<Country> countries){
        for (Country c : covidData.keySet()) {
            double rate = (double)covidData.get(c) / c.getPopulation();
            countries.add(new Country(c.getName(), rate));
        }
    }

    private void loadThreeLargestCases(List<Country> countries, List<Country> threeLargestCases) {
        for (int i = 0; i < 3; i++) {
            threeLargestCases.add(countries.get(i));
        }
    }
}
