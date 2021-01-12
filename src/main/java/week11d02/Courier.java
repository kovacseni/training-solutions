package week11d02;

import java.util.ArrayList;
import java.util.List;

public class Courier {

    private List<Ride> rides =new ArrayList<>();

    public List<Ride> getRides() {
        return rides;
    }

    public void addRide(Ride ride) {
        int a = rides.size();
        if (a == 0) {
            ridesSizeIsZero(ride);
        }
        if (a != 0) {
            ridesSizeIsNotZero(ride);
        }
    }

        public int noWork() {
            boolean[] workDays = new boolean[7];
            for (Ride r : rides) {
                workDays[r.getDay() - 1] = true;
            }
            int firstNoWorkDayInTheWeek = 0;
            while (workDays[firstNoWorkDayInTheWeek] != false) {
                firstNoWorkDayInTheWeek++;
            }
            return firstNoWorkDayInTheWeek + 1;
        }

        private void ridesSizeIsZero(Ride ride) {
            if (ride.getRideNumber() == 1) {
                rides.add(ride);
            } else {
                throw new IllegalArgumentException("Incorrect ride");
            }
        }

        private void ridesSizeIsNotZero(Ride ride) {
            Ride previous = rides.get(rides.size() - 1);
            if (previous.getDay() == ride.getDay() && previous.getRideNumber() + 1 == ride.getRideNumber()) {
                rides.add(ride);
            } else if (previous.getDay() < ride.getDay() && ride.getRideNumber() == 1) {
                rides.add(ride);
            } else {
                throw new IllegalArgumentException("Incorrect ride");
            }
        }
    }
