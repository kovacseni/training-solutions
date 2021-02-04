package week14d04;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ContractCreatorTest {

    @Test
    public void testCreate() {
        List<Integer> monthlyPrices = Arrays.asList(1, 2, 3, 4);
        ContractCreator contractCreator = new ContractCreator("John Doe", monthlyPrices);
        Contract contract = contractCreator.create("Jane Doe");
        Contract contractOther = contractCreator.create("Jack Doe");

        Assertions.assertEquals("Jane Doe", contract.getClient());
        Assertions.assertEquals(2, contract.getMonthlyPrices().get(1));
        Assertions.assertEquals("Jack Doe", contractOther.getClient());
        Assertions.assertEquals(2, contractOther.getMonthlyPrices().get(1));

        contract.getMonthlyPrices().set(1, 5);

        Assertions.assertEquals("Jane Doe", contract.getClient());
        Assertions.assertEquals(5, contract.getMonthlyPrices().get(1));
        Assertions.assertEquals("Jack Doe", contractOther.getClient());
        Assertions.assertEquals(2, contractOther.getMonthlyPrices().get(1));
    }
}
