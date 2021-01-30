package week11d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CourierSenior {

    private List<Ride> rides = new ArrayList<>();

    public CourierSenior(Path path) {
        try (BufferedReader br = Files.newBufferedReader(path)) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] temp = line.split(",");
                rides.add(new Ride(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]), Integer.parseInt(temp[2])));
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not load rides.", ioe);
        }
    }

    public Ride firstRideOfWeek() {
        Ride firstRide = rides.get(0);
        for (Ride r : rides) {
            if (r.getDay() < firstRide.getDay() && r.getRideNumber() == 1) {
                firstRide = r;
            }
        }
        return firstRide;
    }

    public Set<Integer> daysWithoutWork() {
        Set<Integer> withoutWork = new HashSet<>();
        int[] daysOfWeek = new int[7];
        for (Ride r : rides) {
            daysOfWeek[r.getDay() - 1] += 1;
        }
        for (int i = 0; i < daysOfWeek.length;i++) {
            if (daysOfWeek[i] == 0) {
                withoutWork.add(i + 1);
            }
        }

        return withoutWork;
    }

    public int[] getDailyKm() {
        int[] dailyKm = new int[7];
        for (int i = 0; i < rides.size(); i++) {
            dailyKm[rides.get(i).getDay() - 1] += rides.get(i).getKm();
        }
        return dailyKm;
    }
}
