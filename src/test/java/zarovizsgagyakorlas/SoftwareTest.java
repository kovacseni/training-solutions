package zarovizsgagyakorlas;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SoftwareTest {

    @Test
    public void testIncreasePriceOffice() {
        OfficeSoftware os = new OfficeSoftware("Szövegszerkesztő", 100);
        os.increasePrice();

        Assertions.assertEquals(105, os.getPrice());
    }

    @Test
    public void testIncreasePriceDeveloper() {
        DeveloperSoftware ds = new DeveloperSoftware("Fejlesztőeszköz", 200);
        ds.increasePrice();

        Assertions.assertEquals(220, ds.getPrice());
    }
}
