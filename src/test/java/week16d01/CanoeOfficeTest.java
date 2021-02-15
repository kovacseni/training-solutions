package week16d01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

public class CanoeOfficeTest {

    private CanoeOffice co = new CanoeOffice();

    @BeforeEach
    public void setUp() {
        co.addRental(new CanoeRental("Kiss József", CanoeType.BLUE, LocalDateTime.of(2020, 1, 2, 12, 31)));
        co.addRental(new CanoeRental("Nagy Balázs", CanoeType.RED, LocalDateTime.of(2021, 2, 3, 9, 6)));
        co.addRental(new CanoeRental("Szabó Géza", CanoeType.BLUE, LocalDateTime.of(2020, 10, 20, 13, 0)));
        co.addRental(new CanoeRental("Németh Béla", CanoeType.GREEN, LocalDateTime.of(2021, 8, 4, 23, 2)));
        co.addRental(new CanoeRental("Bíró Elemér", CanoeType.RED, LocalDateTime.of(2019, 5, 7, 17, 44)));
    }

    @Test
    public void testFindRentalByName() {
        Assertions.assertEquals("Szabó Géza", co.findRentalByName("Szabó Géza").get().getName());
        Assertions.assertEquals(CanoeType.BLUE, co.findRentalByName("Szabó Géza").get().getCanoeType());
        Assertions.assertEquals(LocalDateTime.of(2020, 10, 20, 13, 0), co.findRentalByName("Szabó Géza").get().getStartTime());
        Assertions.assertEquals(null, co.findRentalByName("Szabó Géza").get().getEndTime());
        Assertions.assertTrue(co.findRentalByName("Szabó Géza").get().isActive());
    }

    @Test
    public void testCloseRentalByName() {
        CanoeRental c1 = co.findRentalByName("Szabó Géza").get();
        co.closeRentalByName("Szabó Géza", LocalDateTime.of(2020, 10, 22, 16, 23));

        Assertions.assertEquals(Optional.empty(), co.findRentalByName("Szabó Géza"));
        Assertions.assertEquals(LocalDateTime.of(2020, 10, 22, 16, 23), c1.getEndTime());
        Assertions.assertFalse(c1.isActive());

        Exception ex = Assertions.assertThrows(NoSuchElementException.class, () -> co.findRentalByName("Szabó Géza").get());
        Assertions.assertEquals("No value present", ex.getMessage());
    }

    @Test
    public void testGetRentalPriceByName() {
        Assertions.assertEquals(228000.0, co.getRentalPriceByName("Németh Béla", LocalDateTime.of(2021, 8, 6, 12, 59)));
    }

    @Test
    public void testListClosedRentals() {
        co.closeRentalByName("Szabó Géza", LocalDateTime.of(2020, 10, 22, 16, 23));
        co.closeRentalByName("Bíró Elemér", LocalDateTime.of(2019, 5, 7, 19, 23));

        List<CanoeRental> closedRentals = co.listClosedRentals();

        Assertions.assertEquals(2, closedRentals.size());
        Assertions.assertEquals("Bíró Elemér", closedRentals.get(0).getName());
        Assertions.assertEquals("Szabó Géza", closedRentals.get(1).getName());
    }

    @Test
    public void testCountRentals() {
        Map<CanoeType, Integer> expected = co.countRentals();

        Assertions.assertEquals(2, expected.get(CanoeType.RED));
        Assertions.assertEquals(1, expected.get(CanoeType.GREEN));
        Assertions.assertEquals(2, expected.get(CanoeType.BLUE));
    }
}
