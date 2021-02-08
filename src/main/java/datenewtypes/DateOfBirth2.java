package datenewtypes;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.time.format.TextStyle;
import java.util.Locale;

public class DateOfBirth2 {

    private LocalDate birthday;

    public DateOfBirth2(int year, int month, int day) {
        this.birthday = LocalDate.of(year, month, day);
    }

    public DateOfBirth2(String dateString) {
        try {
            this.birthday = LocalDate.parse(dateString);
        } catch (DateTimeParseException dtpe) {
            throw new IllegalArgumentException("Illegal date string.", dtpe);
        }
    }

    public String findDayOfWeek() {
        Locale locale = new Locale("hu", "HU");
        return birthday.getDayOfWeek().getDisplayName(TextStyle.FULL, locale);
    }

    public boolean isWeekDay() {
        Locale locale = new Locale("hu", "HU");
        String birth = birthday.getDayOfWeek().getDisplayName(TextStyle.FULL, locale);
        if (birth.equals("szombat") || birth.equals("vasárnap")) {
            return false;
        }
        return true;
    }

    public boolean wasItALeapYear() {
        return birthday.isLeapYear();
    }

    public String findBirthDayOfWeekLater(int year) {
        LocalDate laterBirthday = birthday.withYear(year);
        Locale locale = new Locale("hu", "HU");
        return laterBirthday.getDayOfWeek().getDisplayName(TextStyle.FULL, locale);
    }
}
