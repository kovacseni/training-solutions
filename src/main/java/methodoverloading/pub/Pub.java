package methodoverloading.pub;

import methodoverloading.Time;

public class Pub {

    private String name;
    private Time opentime;

    public Pub(String name, int hours, int minutes) {
        this.name = name;
        this.opentime = new Time(hours, minutes);
    }

    public String getName() {
        return name;
    }

    public Time getOpenFrom() {
        return opentime;
    }

    @Override
    public String toString() {
        return name + ";" + opentime.getHours() + ":" + opentime.getMinutes();
    }
}
