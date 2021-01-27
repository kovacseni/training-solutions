package week08d02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStreamReader;

public class CountryStatistics2Test {

    @Test
    public void tesCountryStatistics2() {
        InputStreamReader isr = new InputStreamReader(CountryStatistics2Test.class.getResourceAsStream("/countriessenior.txt"));
        CountryStatistics2 cs = new CountryStatistics2();
        cs.readFromFile(isr);

        Assertions.assertEquals("Kongoi_Demokratikus_Koztarsasag", cs.maxPopulation().getName());
        Assertions.assertEquals(79, cs.maxPopulation().getPopulation());
        Assertions.assertEquals(3, cs.maxPopulation().getFlag());
        Assertions.assertEquals(9, cs.maxPopulation().getNeighbourCountries());
    }
}
