package datenewtypes;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.List;

public class FamilyBirthdays {

    private List<LocalDate> familyBirthdays = new ArrayList<>();

    public FamilyBirthdays(LocalDate... birthdays) {
        for (LocalDate l : birthdays) {
            familyBirthdays.add(l);
        }
    }

    public boolean isFamilyBirthday(TemporalAccessor date) {
        int month = date.get(ChronoField.MONTH_OF_YEAR);
        int day = date.get(ChronoField.DAY_OF_MONTH);
        boolean isBirthday = false;
        for (LocalDate l : familyBirthdays) {
            if (l.get(ChronoField.MONTH_OF_YEAR) == month && l.get(ChronoField.DAY_OF_MONTH) == day) {
                isBirthday = true;
            }
        }
        return isBirthday;
    }

    public int nextFamilyBirthDay(TemporalAccessor date) {
        int year = date.get(ChronoField.YEAR);
        int month1 = date.get(ChronoField.MONTH_OF_YEAR);
        int day1 = date.get(ChronoField.DAY_OF_MONTH);

        LocalDate date1 = LocalDate.of(year, month1, day1);
        int days = Integer.MAX_VALUE;

        for (LocalDate l : familyBirthdays) {
            /*LocalDate date2 = l.withYear(year);
            if ((int) ChronoUnit.DAYS.between(date1, date2) <= 0 && (int) ChronoUnit.DAYS.between(date1, date2) < days) {
                days = (int) ChronoUnit.DAYS.between(date1, date2);
            }*/
            LocalDate nextBirthday = l.withYear(year);
            if (nextBirthday.isBefore(date1)) {
                nextBirthday = l.withYear(year + 1);
            }
            int diff = (int) ChronoUnit.DAYS.between(date1, nextBirthday);
            if (days > diff) {
                days = diff;
            }
        }
        return days;
    }
}
