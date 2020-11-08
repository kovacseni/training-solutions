package intromethods;

public class EmployeeMain {

    public static void main(String[] args) {

        Employee employee = new Employee("Szép Virág", 2015, 245510);

        System.out.println(employee.getName());
        System.out.println(employee.getHiringYear());
        System.out.println(employee.getSalary());

        employee.setName("Nagyné Szép Virág");
        System.out.println(employee.getName());

        employee.raiseSalary(20500);
        System.out.println(employee.getSalary());

        System.out.println(employee.toString());
    }
}
