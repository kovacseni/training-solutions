package dateoldtypes;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class DateOfBirth {

    private Date date;

    public DateOfBirth(int year, int month, int day) {
        if (month < 1 || month > 12 || day < 1 || day > 31) {
            throw new IllegalArgumentException();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setLenient(false);
        calendar.set(year, month - 1, day);
        this.date = calendar.getTime();
    }

    public DateOfBirth(String dateString, String pattern, Locale locale) {
        if (pattern == null || pattern.isBlank()) {
            throw new IllegalArgumentException("Illegal pattern string, cannot use: " + pattern);
        }
        if (locale == null) {
            throw new NullPointerException("Locale must not be null!");
        }

        DateFormat dateFormat = new SimpleDateFormat(pattern, locale);
        try {
            this.date = dateFormat.parse(dateString);
        } catch (ParseException pe) {
            throw new IllegalArgumentException("Illegal date string, cannot parse: " + dateString, pe);
        }
    }

    public DateOfBirth(String dateString, String pattern) {
        if (pattern == null || pattern.isBlank()) {
            throw new IllegalArgumentException("Illegal pattern string, cannot use: " + pattern);
        }

        DateFormat dateFormat = new SimpleDateFormat(pattern);
        try {
            this.date = dateFormat.parse(dateString);
        } catch (ParseException pe) {
            throw new IllegalArgumentException("Illegal date string, cannot parse: " + dateString, pe);
        }
    }

    public String toString(String pattern) {
        if (pattern == null || pattern.isBlank()) {
            throw new IllegalArgumentException("Illegal pattern string, cannot use: " + pattern);
        }
        DateFormat dateFormat = new SimpleDateFormat(pattern);
        return dateFormat.format(date);
    }

    public String findDayOfWeekForBirthDate(Locale locale) {
        if (locale == null) {
            throw new NullPointerException("Locale must not be null!");
        }

        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        return calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, locale);
    }

    public boolean isWeekDay() {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        return (calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY && calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY);
    }
}