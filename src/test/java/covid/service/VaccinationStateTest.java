package covid.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VaccinationStateTest {

    @Test
    public void getState() {

        Assertions.assertEquals(VaccinationState.NO, VaccinationState.getState(0));
        Assertions.assertEquals(VaccinationState.ONE, VaccinationState.getState(1));
        Assertions.assertEquals(VaccinationState.TWO, VaccinationState.getState(2));

        Exception ex = Assertions.assertThrows(IllegalArgumentException.class, () -> VaccinationState.getState(3));
        Assertions.assertEquals("Nem létező oltottsági státusz!", ex.getMessage());
    }
}