package datedaylight;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class FlightInfo {

    private String dateString;
    private String pattern;
    private Locale locale;
    private ZoneId zone;

    public FlightInfo(String dateString, String pattern, Locale locale, ZoneId zone) {
        if (dateString == null || dateString.isBlank()) {
            throw new IllegalArgumentException("Empty date string parameter!");
        }
        if (pattern == null || pattern.isBlank()) {
            throw new IllegalArgumentException("Empty pattern string parameter!");
        }
        if (locale == null) {
            throw new NullPointerException("Locale must not be null!");
        }

        this.dateString = dateString;
        this.pattern = pattern;
        this.locale = locale;
        this.zone = zone;
    }

    public ZonedDateTime getDepartureDateTime() {
        LocalDateTime date = LocalDateTime.parse(dateString, DateTimeFormatter.ofPattern(pattern, locale));
        return ZonedDateTime.of(date, zone);
    }

    public ZonedDateTime getArrivalDateTime(ZoneId zone, int flightHours, int flightMinutes) {
        ZonedDateTime date = getDepartureDateTime();
        date = date.withZoneSameInstant(zone).plusHours(flightHours).plusMinutes(flightMinutes);
        return date;
    }
}
