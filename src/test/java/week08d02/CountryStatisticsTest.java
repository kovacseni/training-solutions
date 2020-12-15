package week08d02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CountryStatisticsTest {

    private List<String> countriesList;
    private CountryStatistics countryStatistics;

    @BeforeEach
    public void setUp() {
        countriesList = new ArrayList<>();
        countryStatistics = new CountryStatistics(countriesList);
        countryStatistics.readFromFile("/countries.txt");
    }

    @Test
    public void testMaxPopulation() {
        Assertions.assertEquals("Németország 427 3 4", countryStatistics.maxPopulation());
    }
}
