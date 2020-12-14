package interfaces.animal;

public class Duck implements Animal {

    private int numberOfLegs;
    private String name;

    public int getNumberOfLegs() {
        return numberOfLegs = 2;
    }

    public String getName() {
        return name = "Duck";
    }
}
