package introconstructors;

import java.util.List;
import java.util.ArrayList;

public class Restaurant {

    private List<String> menu;
    private String name;
    private int capacity;
    private int hely = 4;
    private String kaja;

    public Restaurant(String name, int numberOfTables) {
        this.name = name;
        this.capacity = numberOfTables * hely;
        this.menu = new ArrayList<>();
    }

    public void addMenu(String kaja) {
        menu.add(kaja);
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<String> getMenu() {
        return menu;
    }


}
