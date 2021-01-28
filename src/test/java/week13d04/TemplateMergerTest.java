package week13d04;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class TemplateMergerTest {

    @Test
    public void testTemplateMerger() {
        Path path = Path.of("src/main/resources/template.txt");
        List<Employee> list = Arrays.asList(new Employee("John Doe", 1980), new Employee("Jack Doe", 1990));

        Assertions.assertEquals("Az alkalmazott neve: John Doe, születési éve: 1980\nAz alkalmazott neve: Jack Doe, születési éve: 1990",
                new TemplateMerger().merge(path, list));
    }
}
