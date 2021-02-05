package datenewtypes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class DateOfBirth {

    private LocalDate dateOfBirth;

    public DateOfBirth(int year, int month, int day) {
        this.dateOfBirth = LocalDate.of(year, month, day);
    }

    public DateOfBirth(String dateString, String patternString) {
        if (patternString == null || patternString.isBlank()) {
            throw new IllegalArgumentException("Empty pattern string, cannot use: " + patternString);
        }
        try {
            this.dateOfBirth = LocalDate.parse(dateString, DateTimeFormatter.ofPattern(patternString));
        } catch (DateTimeParseException dtpe) {
            throw new IllegalArgumentException("Illegal date string!");
        }
    }

    public DateOfBirth(String dateString, String patternString, Locale locale) {
        if (patternString == null || patternString.isBlank()) {
            throw new IllegalArgumentException("Empty pattern string, cannot use: " + patternString);
        }
        if (locale == null) {
            throw new NullPointerException("Locale must not be null!");
        }
        try {
            this.dateOfBirth = LocalDate.parse(dateString, DateTimeFormatter.ofPattern(patternString, locale));
        } catch (DateTimeParseException dtpe) {
            throw new IllegalArgumentException("Illegal date string!");
        }
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String toString(String patternString) {
        if (patternString == null || patternString.isBlank()) {
            throw new IllegalArgumentException("Empty pattern string, cannot use: " + patternString);
        }
        return this.dateOfBirth.format(DateTimeFormatter.ofPattern(patternString));
    }

    public String findDayOfWeekForBirthDate(Locale locale) {
        if (locale == null) {
            throw new NullPointerException("Locale must not be null!");
        }
        return dateOfBirth.getDayOfWeek().getDisplayName(TextStyle.FULL, locale);
    }

    public String findDayOfWeekForBirthDate(Locale locale, LocalDate birthDate) {
        if (locale == null) {
            throw new IllegalArgumentException("Locale must not be null!");
        }
        return birthDate.getDayOfWeek().getDisplayName(TextStyle.FULL, locale);
    }

    public int countDaysBetween(DateOfBirth otherDateOfBirth) {
        return (int)ChronoUnit.DAYS.between(dateOfBirth, otherDateOfBirth.dateOfBirth);
    }

    public int countDaysSinceBirth(LocalDate date) {
        if (date.isBefore(dateOfBirth)) {
            throw new IllegalStateException("Birthdate is in the future!");
        }
        int year = date.getYear();
        int month = date.getMonthValue();
        int day = date.getDayOfMonth();
        DateOfBirth other = new DateOfBirth(year, month, day);

        return countDaysBetween(other);
    }
}
