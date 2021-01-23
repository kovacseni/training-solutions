package timesheet;

public class Project {

    private String name;

    public Project(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Must add name!");
        }

        this.name = name;
    }

    public String getName() {
        return name;
    }
}
