package week13d02;

import java.time.LocalTime;

public class Flight {

    private String flightNumber;
    private FlightType flightType;
    private String city;
    private LocalTime time;

    public Flight(String flightNumber, FlightType flightType, String city, LocalTime time) {
        this.flightNumber = flightNumber;
        this.flightType = flightType;
        this.city = city;
        this.time = time;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public FlightType getFlightType() {
        return flightType;
    }

    public String getCity() {
        return city;
    }

    public LocalTime getTime() {
        return time;
    }

    @Override
    public String toString() {
        return flightNumber + " " + flightType + " " + city + " " + time;
    }
}
