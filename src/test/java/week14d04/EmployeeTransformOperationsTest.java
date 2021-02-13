package week14d04;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class EmployeeTransformOperationsTest {

    @Test
    public void testTransformToUppercased() {
        List<Employee> employees = Arrays.asList(new Employee("Kiss József"), new Employee("Nagy Béla"), new Employee("Szabó Géza"));
        List<Employee> employeesUpper = new EmployeeTransformOperations().transformToUpperCased(employees);

        Assertions.assertEquals(3, employees.size());
        Assertions.assertEquals("Kiss József", employees.get(0).getName());
        Assertions.assertEquals("Nagy Béla", employees.get(1).getName());
        Assertions.assertEquals("Szabó Géza", employees.get(2).getName());

        Assertions.assertEquals(3, employeesUpper.size());
        Assertions.assertEquals("KISS JÓZSEF", employeesUpper.get(0).getName());
        Assertions.assertEquals("NAGY BÉLA", employeesUpper.get(1).getName());
        Assertions.assertEquals("SZABÓ GÉZA", employeesUpper.get(2).getName());
    }
}
