package datedaylight;

import java.time.*;

public class WorkHoursCalculator {

    private int startYear;
    private Month month;
    private int startDay;
    private int startHour;
    ZoneId zone;

    public WorkHoursCalculator(int startYear, Month month, int startDay, int startHour, ZoneId zone) {
        this.startYear = startYear;
        this.month = month;
        this.startDay = startDay;
        this.startHour = startHour;
        this.zone = zone;
    }

    public ZonedDateTime getStartDateTime() {
        LocalDateTime date = LocalDateTime.of(startYear, month, startDay, startHour, 0);
        return ZonedDateTime.of(date, zone);
    }

    public long calculateHours(int year, Month month, int day, int hour) {
        int monthNumber = month.getValue();
        ZonedDateTime date1 = getStartDateTime();
        ZonedDateTime date2 = ZonedDateTime.of(year, monthNumber, day, hour, 0, 0, 0, zone);
        Duration duration = Duration.between(date1, date2);
        return duration.toHours();
    }
}
