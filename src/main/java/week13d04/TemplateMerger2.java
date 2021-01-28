package week13d04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class TemplateMerger2 {

    public String merge(Path file, List<Employee> employees) {
        StringBuilder sb = new StringBuilder();
        String line;
        try {
            line = (Files.readString(file));
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file.", ioe);
        }
        putEmployeesInTemplate(sb, line, employees);
        return sb.toString().trim();
    }

    private void putEmployeesInTemplate(StringBuilder sb, String line, List<Employee> employees) {

        for (Employee e : employees) {
            String replaced = line.replace("{nev}", e.getName());
            replaced = replaced.replace("{ev}", Integer.toString(e.getYearOfBirth()));
            sb.append(replaced).append("\n");
        }
    }

    public static void main(String[] args) {
        Path path = Path.of("src/main/resources/template.txt");
        List<Employee> list = Arrays.asList(new Employee("John Doe", 1980), new Employee("Jack Doe", 1990));
        System.out.println(new TemplateMerger2().merge(path, list));
    }
}
