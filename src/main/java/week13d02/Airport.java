package week13d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Airport {

    private List<Flight> flights = new ArrayList<>();

    public List<Flight> getFlights() {
        return new ArrayList<>(flights);
    }

    public void readFile(Path path) {
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                addFlight(line);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }

    public FlightType whatsMore() {
        int countArrival = 0;
        int countDeparture = 0;
        for (Flight item : flights) {
            if (item.getFlightType() == FlightType.ARRIVAL) {
                countArrival++;
            } else {
                countDeparture++;
            }
        }

        if (countArrival >= countDeparture) {
            return FlightType.ARRIVAL;
        }
        return FlightType.DEPARTURE;
    }

    public Flight getFlightByNumber(String flightNumber) {
        for (Flight item : flights) {
            if (item.getFlightNumber().equals(flightNumber)) {
                return item;
            }
        }
        throw new IllegalArgumentException("Can not find flight");
    }

    public List<Flight> findFlights(String city, FlightType flightType) {
        List<Flight> report = new ArrayList<>();
        for (Flight item : flights) {
            if (item.getCity().equals(city) && item.getFlightType() == flightType) {
                report.add(item);
            }
        }
        return report;
    }

    public Flight getEarliestDepartureFlight() {
        LocalTime time = LocalTime.of(23, 59);
        Flight earliest = firstDepartureInList();
        for (Flight item : flights) {
            if (item.getTime().isBefore(time) && item.getFlightType() == FlightType.DEPARTURE) {
                time = item.getTime();
                earliest = item;
            }
        }
        return earliest;
    }

    private void addFlight(String line) {
        String[] arr = line.split(" ");
        String[] time = arr[3].split(":");
        int timeHour = Integer.parseInt(time[0]);
        int timeMinute = Integer.parseInt(time[1]);

        flights.add(new Flight(arr[0], FlightType.valueOf(arr[1].toUpperCase()), arr[2], LocalTime.of(timeHour, timeMinute)));
    }

    private Flight firstDepartureInList() {
        Flight first = null;
        for (Flight item : flights) {
            if (item.getFlightType() == FlightType.DEPARTURE) {
                first = item;
            }
        }
        return first;
    }
}
