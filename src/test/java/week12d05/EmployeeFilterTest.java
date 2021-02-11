package week12d05;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmployeeFilterTest {

    private List<Employee> employees;

    @BeforeEach
    public void setUp() {
        employees = new ArrayList<>();
        employees.add(new Employee(34, 2, "Jóska", Arrays.asList("programming", "xy", "yz")));
        employees.add(new Employee(23, 3, "Pista", Arrays.asList("ab", "bc", "programming")));
        employees.add(new Employee(43, 1, "Béla", Arrays.asList("cd", "de")));
        employees.add(new Employee(52, 4, "Géza", Arrays.asList("ef", "programming", "fg")));
        employees.add(new Employee(53, 5, "Sanyi", Arrays.asList("gh", "hi", "ij")));
    }

    @Test
    public void testCountSeniorDevs() {
        List<Employee> expected = new EmployeeFilter().countSeniorDevs(employees);

        Assertions.assertEquals(2, expected.size());
        Assertions.assertEquals("Pista", expected.get(0).getName());
        Assertions.assertEquals("Géza", expected.get(1).getName());
    }

    @Test
    public void testCountSeniorDevsWithStream() {
        List<Employee> expected = new EmployeeFilter().countSeniorDevsWithStream(employees);

        Assertions.assertEquals(2, expected.size());
        Assertions.assertEquals("Pista", expected.get(0).getName());
        Assertions.assertEquals("Géza", expected.get(1).getName());
    }
}
