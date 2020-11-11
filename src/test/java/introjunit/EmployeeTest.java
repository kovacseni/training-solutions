package introjunit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeTest {

    @Test
    public void testCreate() {
        //Given
        Employee employee = new Employee("John", 32);

        //When
        String resultName = employee.getName();

        //Then
        assertEquals("John", resultName);
    }

    @Test
    public void testHaveBirthday() {
        //Given
        Employee employee = new Employee("Jack", 23);

        //When
        int resultAge = employee.haveBirthday();

        //Then
        assertEquals(23, resultAge);

    }
}
