package week08d02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CountryStatistics {

    private List<String> countriesList;

    public CountryStatistics(List<String> countriesList) {
        this.countriesList = countriesList;
    }

    public List<String> getCountriesList() {
        return List.copyOf(countriesList);
    }

    public List<String> readFromFile(String path) {
        Scanner scanner = new Scanner(CountryStatistics.class.getResourceAsStream(path));
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            countriesList.add(line);
        }
        return countriesList;
    }

    public String maxPopulation() {
        String maxAll = null;
        int max = 0;
        for (String s : countriesList) {
            int indexOfPopulation = s.indexOf(" ");
            int index2 = s.indexOf(" ", indexOfPopulation + 1);
            int population = Integer.parseInt(s.substring(indexOfPopulation + 1, index2));
            if (population > max) {
                max = population;
                maxAll = s;
            }
        }
        return maxAll;
    }
}
