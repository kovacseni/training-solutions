package timesheet;

public class Employee {

    private String firstName;
    private String lastName;

    public Employee(String firstName, String lastName) {
        if (firstName == null || lastName ==null) {
            throw new IllegalArgumentException("Must add name!");
        }

        this.firstName= firstName;
        this.lastName = lastName;
    }

    public String getName() {
        return firstName + " " + lastName;
    }
}
