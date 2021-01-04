package week09d03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class SantaClausTest {

    private List<Person> listOfPerson;

    @BeforeEach

    public void setUp() {
        listOfPerson = new ArrayList<>();
        listOfPerson.add(new Person("Apa", 43));
        listOfPerson.add(new Person("Anya", 42));
        listOfPerson.add(new Person("Józsi", 17));
        listOfPerson.add(new Person("Pisti", 14));
        listOfPerson.add(new Person("Rozi", 11));
        listOfPerson.add(new Person("Marcsi", 9));
    }

    @Test
    public void testSantaClaus1() {
        Assertions.assertEquals(Present.ELECTRONIC, new SantaClaus(listOfPerson).getThroughChimneys().get(0).getPresent());
    }

    @Test
    public void testSantaClaus2() {
        Assertions.assertEquals(Present.HOUSEKEEPING, new SantaClaus(listOfPerson).getThroughChimneys().get(4).getPresent());
    }
}
