package covid.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VaccineTypeTest {

    @Test
    public void getType() {

        Assertions.assertEquals(VaccineType.PFIZER, VaccineType.getType(1));
        Assertions.assertEquals(VaccineType.MODERNA, VaccineType.getType(2));
        Assertions.assertEquals(VaccineType.ASTRA_ZENECA, VaccineType.getType(3));
        Assertions.assertEquals(VaccineType.SZPUTNYIK, VaccineType.getType(4));
        Assertions.assertEquals(VaccineType.SINOPHARM, VaccineType.getType(5));

        Exception ex = Assertions.assertThrows(IllegalArgumentException.class, () -> VaccineType.getType(6));
        Assertions.assertEquals("Nem létező vakcinatípus!", ex.getMessage());
    }
}