package datenewtypes;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;

public class DailyRoutine {

    private LocalTime startTime;
    private LocalTime endTime;

    public DailyRoutine(int hour, int minute) {
        this.startTime = LocalTime.of(hour, minute);
    }

    public DailyRoutine(String timeString) {
        try {
            this.startTime = LocalTime.parse(timeString);
        } catch (DateTimeParseException dtpe) {
            throw new IllegalArgumentException("Illegal string format.", dtpe);
        }
    }

    public void setFutureTime(int minutes) {
        this.endTime = startTime.plusMinutes(minutes);
    }

    public boolean isBeforeNoon() {
        return endTime.isBefore(LocalTime.NOON);
    }
}
