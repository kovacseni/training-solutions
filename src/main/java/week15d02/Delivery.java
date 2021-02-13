package week15d02;

import java.time.LocalTime;

public class Delivery {

    private String id;
    private String address;
    private LocalTime time;

    public Delivery(String address, LocalTime time) {
        this.address = address;
        this.time = time;
    }

    public Delivery(String id, String address, LocalTime time) {
        this(address, time);
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public LocalTime getTime() {
        return time;
    }

    @Override
    public String toString() {
        if (this.id == null) {
            return address + " " + time;
        }
        return id + " " + address + " " + time;
    }
}
