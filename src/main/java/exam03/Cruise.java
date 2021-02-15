package exam03;

import java.time.LocalDate;
import java.util.*;

public class Cruise {

    private Boat boat;
    private LocalDate sailing;
    private double basicPrice;
    private List<Passenger> passengers = new ArrayList<>();

    public Cruise(Boat boat, LocalDate sailing, double basicPrice) {
        this.boat = boat;
        this.sailing = sailing;
        this.basicPrice = basicPrice;
    }

    public Boat getBoat() {
        return boat;
    }

    public LocalDate getSailing() {
        return sailing;
    }

    public double getBasicPrice() {
        return basicPrice;
    }

    public List<Passenger> getPassengers() {
        return new ArrayList<>(passengers);
    }

    public void bookPassenger(Passenger passenger) {
        if (passengers.size() < this.boat.getMaxPassengers()) {
            passengers.add(passenger);
        } else {
            throw new IllegalArgumentException("Boat can not be overbooked!");
        }
    }

    public double getPriceForPassenger(Passenger passenger) {
        double rate = passenger.getCruiseClass().getRate();
        return this.basicPrice * rate;
    }

    public Passenger findPassengerByName(String name) {
        Passenger result = passengers.get(0);
        for (Passenger p : passengers) {
            if (p.getName().equals(name)) {
                result = p;
            }
        }
        return result;
    }

    public List<String> getPassengerNamesOrdered() {
        List<String> ordered = new ArrayList<>();
        for (Passenger p : passengers) {
            ordered.add(p.getName());
        }
        Collections.sort(ordered);
        return ordered;
    }

    public double sumAllBookingsCharged() {
        double sum = 0.0;
        for (Passenger p : passengers) {
            double rate = p.getCruiseClass().getRate();
            sum += this.basicPrice * rate;
        }
        return sum;
    }

    public Map<CruiseClass, Integer> countPassengerByClass() {
        Map<CruiseClass, Integer> result = new HashMap<>();
        for (Passenger p : passengers) {
            CruiseClass cruiseClass = p.getCruiseClass();
            if (!result.containsKey(cruiseClass)) {
                result.put(cruiseClass, 1);
            } else {
                result.put(cruiseClass, result.get(cruiseClass) + 1);
            }
        }
        return result;
    }
}
