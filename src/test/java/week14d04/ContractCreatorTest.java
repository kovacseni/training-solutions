package week14d04;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ContractCreatorTest {

    @Test
    public void testCreate() {
        List<Integer> monthlyPrices = Arrays.asList(1, 2, 3, 4);
        Contract contract = new ContractCreator("John Doe", monthlyPrices).create("Jane Doe");

        Assertions.assertEquals("Jane Doe", contract.getClient());
        Assertions.assertEquals(2, contract.getMonthlyPrices().get(1));
    }
}
