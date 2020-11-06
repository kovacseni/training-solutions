package debug.employees;

import java.util.ArrayList;
import java.util.List;

public class Company {

    private List<Employee> employees = new ArrayList<>();

    public Company(List<Employee> employees){
        this.employees = employees;
    }

    public void addEmployee(Employee ujDolgozo) {
        employees.add(ujDolgozo);
    }

    public Employee findEmployeeByName(String name) {
        for (Employee findEmp : employees) {
            if (findEmp.getName().equals(name)) {
                return findEmp;
            }
        }
        return null;
    }

    public List<String> listEmployeeNames() {
        List<String> dolgozok = new ArrayList<>();
        for (Employee dolgozo : employees) {
            dolgozok.add(dolgozo.getName());
        }
        return dolgozok;
    }

}
