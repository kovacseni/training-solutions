package week16d01;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class CanoeOffice {

    private List<CanoeRental> rentals = new ArrayList<>();

    public void addRental(CanoeRental rental) {
        rentals.add(rental);
    }

    public Optional<CanoeRental> findRentalByName(String name) {
        return rentals.stream().filter(r -> r.isActive()).filter(r -> r.getName().equals(name)).findFirst();
    }

    public void closeRentalByName(String name, LocalDateTime endTime) {
        for (CanoeRental cr : rentals) {
            if (cr.getName().equals(name) && cr.isActive()) {
                cr.setEndTime(endTime);
            }
        }
    }

    public double getRentalPriceByName(String name, LocalDateTime endTime) {
        double rentalPrice = 1.0;
        for (CanoeRental cr : rentals) {
            if (cr.getName().equals(name) && cr.isActive()) {
                int hours = (int)Duration.between(cr.getStartTime(), endTime).toHours() + 1;
                rentalPrice *= cr.calculateRentalSum() * hours;
            }
        }
        return rentalPrice;
    }

    public List<CanoeRental> listClosedRentals() {
        List<CanoeRental> closedRentals = rentals.stream().filter(r -> !r.isActive()).collect(Collectors.toList());
        closedRentals.sort(Comparator.comparing(CanoeRental::getStartTime));
        return closedRentals;
    }

    public Map<CanoeType, Integer> countRentals() {
        Map<CanoeType, Integer> rentalsByType = new HashMap<>();
        putTypesToMap(rentalsByType);
        for (CanoeRental cr : rentals) {
            rentalsByType.put(cr.getCanoeType(), rentalsByType.get(cr.getCanoeType()) + 1);
        }
        return rentalsByType;
    }

    private void putTypesToMap(Map<CanoeType, Integer> rentalsByType) {
        for (CanoeType c : CanoeType.values()) {
            rentalsByType.put(c, 0);
        }
    }
}
