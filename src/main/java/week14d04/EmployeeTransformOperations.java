package week14d04;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeTransformOperations {

    public List<Employee> transformToUpperCased(List<Employee> employees) {
        return employees.stream().map(e -> {return new Employee(e.getName().toUpperCase());}).collect(Collectors.toList());
    }
}
