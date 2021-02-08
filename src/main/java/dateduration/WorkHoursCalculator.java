package dateduration;

import java.time.Duration;
import java.time.format.DateTimeParseException;

public class WorkHoursCalculator {

    private Duration workTimes = Duration.ZERO;

    public void addWorkTime(Duration duration) {
        workTimes = workTimes.plus(duration);
    }

    public void addWorkTime(int days, int hours, int minutes) {
        Duration duration = Duration.ofMinutes(minutes);
        duration = duration.plus(Duration.ofHours(hours));
        duration = duration.plus(Duration.ofDays(days));
        workTimes = workTimes.plus(duration);
    }

    public void addWorkTime(String durationString) {
        if (durationString == null || durationString.isBlank()) {
            throw new IllegalArgumentException("Parameter must not be empty!");
        }

        try {
            workTimes = workTimes.plus(Duration.parse(durationString));
        } catch (DateTimeParseException dtpe) {
            throw new IllegalArgumentException("Parameter must match PnDTnHnM pattern, but found: " + durationString, dtpe);
        }
    }

    public int calculateWorkHours() {
        return (int)workTimes.toHours();
    }

    public Duration getWorkDuration() {
        return workTimes;
    }

    public String toString() {
        Duration duration = getWorkDuration();
        return "Days: " + duration.toDaysPart() + ", hours: " + duration.toHoursPart() + ", minutes: " + duration.toMinutesPart();
    }
}
