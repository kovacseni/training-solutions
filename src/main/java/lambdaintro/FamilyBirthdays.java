package lambdaintro;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FamilyBirthdays {

    /*private List<LocalDate> birthDays;

    public FamilyBirthdays(LocalDate... birthDay) {
         this.birthDays = Arrays.asList(birthDay);
    }

    public boolean isFamilyBirthday(LocalDate date) {
        int month = date.getMonthValue();
        int day = date.getDayOfMonth();
        boolean isBirthDay = false;
        for (LocalDate ld : birthDays) {
            if (ld.getMonthValue() == month && ld.getDayOfMonth() == day) {
                isBirthDay = true;
            }
        }
        return isBirthDay;
    }

    public int nextFamilyBirthDay(LocalDate date) {
        List<LocalDate> after = birthDays.stream().filter(ld -> ld.isAfter(date)).collect(Collectors.toList());
        Collections.sort(after);
        LocalDate nextBirthDay = after.get(0);
        int diff = (int) ChronoUnit.DAYS.between(date, nextBirthDay);
        return diff;
    }*/

    private List<LocalDate> birthdays;

    public FamilyBirthdays(LocalDate... birthdays) {
        this.birthdays = Arrays.asList(birthdays);
    }

    public boolean isFamilyBirthday(TemporalAccessor date) {
        int month = date.get(ChronoField.MONTH_OF_YEAR);
        int day   = date.get(ChronoField.DAY_OF_MONTH);

        for (LocalDate birthday: birthdays) {
            if ((birthday.get(ChronoField.MONTH_OF_YEAR) == month) &&
                    (birthday.get(ChronoField.DAY_OF_MONTH) == day)) {
                return true;
            }
        }
        return false;
    }

    public int nextFamilyBirthDay(TemporalAccessor date) {
        int year = date.get(ChronoField.YEAR);
        LocalDate base = LocalDate.of(year, date.get(ChronoField.MONTH_OF_YEAR), date.get(ChronoField.DAY_OF_MONTH));

        int min = Integer.MAX_VALUE;

        for (LocalDate birthday: birthdays) {
            LocalDate nextBirthday = birthday.withYear(year);
            if (nextBirthday.isBefore(base)) {
                nextBirthday = birthday.withYear(year + 1);
            }
            int diff = (int) ChronoUnit.DAYS.between(base, nextBirthday);
            if (min > diff) {
                min = diff;
            }
        }
        return min;
    }
}