package week08d02;

public class Country {

    private String name;
    private int population;
    private int flag;
    private int neighbourCountries;

    public Country(String name, int population, int flag, int neighbourCountries) {
        this.name = name;
        this.population = population;
        this.flag = flag;
        this.neighbourCountries = neighbourCountries;
    }

    public String getName() {
        return name;
    }

    public int getPopulation() {
        return population;
    }

    public int getFlag() {
        return flag;
    }

    public int getNeighbourCountries() {
        return neighbourCountries;
    }
}
