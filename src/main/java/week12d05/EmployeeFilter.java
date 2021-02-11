package week12d05;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeFilter {

    public List<Employee> countSeniorDevs(List<Employee> employees) {
        List<Employee> result = new ArrayList<>();
        for (Employee e : employees) {
            if (e.getSkills().contains("programming") && e.getSkillLevel() >= 3) {
                result.add(e);
            }
        }
        return result;
    }

    public List<Employee> countSeniorDevsWithStream(List<Employee> employees) {
        List<Employee> result = employees.stream().filter(e -> e.getSkills().contains("programming")).filter(e -> e.getSkillLevel() >= 3).collect(Collectors.toList());
        return result;
    }
}