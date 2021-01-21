package iofilestest.cheese;

public class Cheese {

    private String name;
    private double lactoseInhalt;

    public Cheese(String name, double lactoseInhalt) {
        this.name = name;
        this.lactoseInhalt = lactoseInhalt;
    }

    public String getName() {
        return name;
    }

    public double getLactoseInhalt() {
        return lactoseInhalt;
    }
}
