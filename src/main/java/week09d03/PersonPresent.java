package week09d03;

public class PersonPresent {

    private String name;
    private Present present;

    public PersonPresent(String name, Present present) {
        this.name = name;
        this.present = present;
    }

    public String getName() {
        return name;
    }

    public Present getPresent() {
        return present;
    }
}
