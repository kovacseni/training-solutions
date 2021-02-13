package week15d05;

import java.util.Objects;

public class Country {

    private String name;
    private int population;
    private double rate;

    public Country(String name, int population) {
        this.name = name;
        this.population = population;
    }

    public Country(String name, double rate) {
        this.name = name;
        this.rate = rate;
    }

    public String getName() {
        return name;
    }

    public int getPopulation() {
        return population;
    }

    public double getRate() {
        return rate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return population == country.population &&
                Objects.equals(name, country.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, population);
    }

    @Override
    public String toString() {
        if (rate == 0.0) {
            return name;
        }
        return name + ": " + rate;
    }
}
