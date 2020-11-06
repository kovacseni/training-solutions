package debug.employees;

import java.util.ArrayList;
import java.util.List;

public class CompanyMain {

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();

        Employee dolgozo1 = new Employee("Kovács Jóska", 1979);
        Employee dolgozo2 = new Employee("Kiss Pista", 1980);
        Employee dolgozo3 = new Employee("Nagy Béla", 1981);
        Employee dolgozo4 = new Employee("Vékony Margit", 1982);

        Company company = new Company(employees);

        company.addEmployee(dolgozo1);
        company.addEmployee(dolgozo2);
        company.addEmployee(dolgozo3);
        company.addEmployee(dolgozo4);

        System.out.println(company.listEmployeeNames());

        Employee benneVanAListaban = company.findEmployeeByName("Nagy Béla");
        System.out.println(benneVanAListaban.getName());

    }
}
