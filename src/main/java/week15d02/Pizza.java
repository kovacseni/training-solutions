package week15d02;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.*;

public class Pizza {

    private Map<String, List<LocalTime>> deliveriesByAddress = new HashMap<>();
    private Map<String, List<Delivery>> deliveriesByCourier = new HashMap<>();
    private Map<LocalDate, List<Delivery>> deliveriesByDay = new HashMap<>();


    public void loadFromFile(Reader reader) {
        try (BufferedReader br = new BufferedReader(reader)) {
            load(br);
        } catch (IOException | DateTimeParseException ex) {
            throw new IllegalStateException("Can not handle file.", ex);
        }
    }

    private void load(BufferedReader br) throws IOException, DateTimeParseException {
        List<String> lines = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null) {
            lines.add(line);
        }
        putToMaps(lines);
    }

    private void putToMaps(List<String> lines) throws DateTimeParseException {
        for (int i = 0; i < lines.size(); i++) {
            if (lines.get(i).startsWith("2")) {
                String dateString = lines.get(i).replace(".", "-");
                LocalDate date = LocalDate.parse(dateString);
                putToMaps2(i, lines, date);
            }
        }
    }

    private void putToMaps2(int i, List<String> lines, LocalDate date) throws DateTimeParseException {
        for (int j = i + 1; j < lines.size(); j++) {
            if (lines.get(j).startsWith("FUT")) {
                String id = lines.get(j);
                String line2 = lines.get(j + 1);
                String[] temp = line2.split(" ");
                String address = temp[0] + " " + temp[1] + " " + temp[2];
                LocalTime time = LocalTime.parse(temp[3]);
                getDeliveriesByAddress(address, time);
                getDeliveriesByCourier(id, address, time);
                getDeliveriesByDay(date, id, address, time);
            }
            if (lines.get(j).startsWith("2")) {
                break;
            }
        }
    }


    private void getDeliveriesByAddress(String address, LocalTime time) {
        if (!deliveriesByAddress.containsKey(address)) {
            deliveriesByAddress.put(address, new ArrayList<>());
        }
        deliveriesByAddress.get(address).add(time);
    }

    private void getDeliveriesByCourier(String id, String address, LocalTime time) {
        if (!deliveriesByCourier.containsKey(id)) {
            deliveriesByCourier.put(id, new ArrayList<>());
        }
        deliveriesByCourier.get(id).add(new Delivery(address, time));
    }

    private void getDeliveriesByDay(LocalDate date, String id, String address, LocalTime time) {
        if (!deliveriesByDay.containsKey(date)) {
            deliveriesByDay.put(date, new ArrayList<>());
        }
        deliveriesByDay.get(date).add(new Delivery(id, address, time));
    }

    public LocalDate getDayWithLeastOrders() {
        int min = Integer.MAX_VALUE;
        LocalDate least = null;
        for (LocalDate l : deliveriesByDay.keySet()) {
            if (deliveriesByDay.get(l).size() < min) {
                min = deliveriesByDay.get(l).size();
                least = l;
            }
        }
        return least;
    }

    public Delivery getExactOrder(LocalDate date, LocalTime time) {
        Delivery exact = null;
        for (Delivery d : deliveriesByDay.get(date)) {
            if (d.getTime().equals(time)) {
                exact = d;
            }
        }
        return new Delivery(exact.getAddress(), exact.getTime());
    }

    public Map<String, Integer> getCourierStatistics() {
        Map<String, Integer> courierStatistics = new TreeMap<>();
        for (String s : deliveriesByCourier.keySet()) {
            courierStatistics.put(s, deliveriesByCourier.get(s).size());
        }
        return courierStatistics;
    }

    public String getAddressWithMostOrders() {
        String address = null;
        int max = 0;
        for (String s : deliveriesByAddress.keySet()) {
            if (deliveriesByAddress.get(s).size() > max) {
                max = deliveriesByAddress.get(s).size();
                address = s;
            }
        }
        return address;
    }
}
