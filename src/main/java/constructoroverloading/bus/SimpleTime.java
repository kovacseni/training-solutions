package constructoroverloading.bus;

public class SimpleTime {

    private int hours;
    private int minutes;
    private SimpleTime time;

    public SimpleTime(int hours, int minutes) {
        this.hours = hours;
        this.minutes = minutes;
    }

    public SimpleTime(int hours) {
        this(hours, 0);
    }

    public SimpleTime(SimpleTime time) {
        this(time.hours, time.minutes);
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int difference(SimpleTime time) {
        int thisTime = this.hours * 60 + this.minutes;
        int anotherTime = time.hours * 60 + time.minutes;
        return (thisTime - anotherTime);
    }

    public String toString() {
        return hours + ":" + minutes;
    }
}
