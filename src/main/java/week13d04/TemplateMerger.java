package week13d04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class TemplateMerger {

    public String merge(Path file, List<Employee> employees) {
        StringBuilder sb = new StringBuilder();
        try {
            sb = sb.append(Files.readString(file));
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file.", ioe);
        }
        StringBuffer result = putEmployeesInTemplate(sb, employees);
        return result.toString().trim();
    }

    private StringBuffer putEmployeesInTemplate(StringBuilder sb, List<Employee> employees) {
        StringBuffer result = new StringBuffer();
        String helpString = sb.toString();

        for (Employee e : employees) {
            int[] nameIndexes = getIndexesOfStringsToReplace(sb);
            sb.replace(nameIndexes[0], nameIndexes[1], e.getName());
            int[] yearIndexes = getIndexesOfStringsToReplace(sb);
            sb.replace(yearIndexes[0], yearIndexes[1], Integer.toString(e.getYearOfBirth()));
            result.append(sb.toString()). append("\n");
            sb.delete(0, sb.toString().length()).append(helpString);
        }
        return result;
    }

    private int[] getIndexesOfStringsToReplace(StringBuilder sb) {
        String temp = sb.toString();

        int index1 = temp.indexOf("{");
        int index2 = temp.indexOf("}") + 1;
        int[] indexes = new int[] {index1, index2};

        return indexes;
    }

    public static void main(String[] args) {
        Path path = Path.of("src/main/resources/template.txt");
        List<Employee> list = Arrays.asList(new Employee("John Doe", 1980), new Employee("Jack Doe", 1990));
        System.out.println(new TemplateMerger().merge(path, list));
    }
}
