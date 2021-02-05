package datenewtypes;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;

public class Rendezvous {

    private LocalTime meetingTime;

    public Rendezvous(String timeString, String patternString) {
        if (patternString == null || patternString.isBlank()){
            throw new IllegalArgumentException("Empty pattern string!");
        }
        if (timeString == null || timeString.isBlank() || timeString.length() > 5 || timeString.length() < 5) {
            throw new IllegalArgumentException("Illegal time string: " + timeString);
        }
        try {
            this.meetingTime = LocalTime.parse(timeString, DateTimeFormatter.ofPattern(patternString));
        } catch (DateTimeParseException dtpe) {
            throw new IllegalArgumentException();
        }
    }

    public Rendezvous(int hour, int minute) {
        try {
            this.meetingTime = LocalTime.of(hour, minute);
        } catch (DateTimeParseException dtpe) {
            throw new IllegalArgumentException();
        }
    }

    public String toString(String patternString) {
        if (patternString == null || patternString.isBlank()) {
            throw new IllegalArgumentException("Empty pattern string!");
        }
        return this.meetingTime.format(DateTimeFormatter.ofPattern(patternString));
    }

    public int countMinutesLeft(LocalTime other) {
        if (other.isAfter(this.meetingTime)) {
            throw new MissedOpportunityException("Too late!");
        }
        return (int)ChronoUnit.MINUTES.between(other, this.meetingTime);
    }

    public void pushLater(int hour, int minute) {
        meetingTime = meetingTime.plusHours(hour).plusMinutes(minute);
    }

    public void pullEarlier(int hour, int minute) {
        meetingTime = meetingTime.minusHours(hour).minusMinutes(minute);
    }
}
