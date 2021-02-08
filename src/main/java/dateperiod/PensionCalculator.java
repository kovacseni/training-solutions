package dateperiod;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class PensionCalculator {

    private List<Period> periods = new ArrayList<>();

    public void addEmploymentPeriod(Period period) {
        period = fullyNormalized(period);
        periods.add(period);
    }

    public Period sumEmploymentPeriods() {
        Period sum = Period.of(0, 0, 0);
        for (Period p : periods) {
            sum = sum.plus(p);
        }
        return sum;
    }

    public Period modifyByDays(Period period, int days) {
        period = period.plusDays(days);
        period = fullyNormalized(period);
        return period;
    }

    public Period getPeriodBetweenDates(LocalDate fromDate, LocalDate toDate) {
        if (fromDate == null || toDate == null) {
            throw new NullPointerException("Null parameters are not allowed!");
        }

        Period period = Period.between(fromDate, toDate);
        period = fullyNormalized(period);
        return period;
    }

    public Period getPeriodBetweenDates(String fromDate, String toDate, String pattern) {
        if (isEmpty(fromDate)) {
            throw new IllegalArgumentException("Empty from date string, cannot use: " + fromDate);
        }
        if (isEmpty(toDate)) {
            throw new IllegalArgumentException("Empty to date string, cannot use: " + toDate);
        }
        if (isEmpty(pattern)) {
            throw new IllegalArgumentException("Empty pattern string, cannot use: " + pattern);
        }

        try {
            LocalDate from = LocalDate.parse(fromDate, DateTimeFormatter.ofPattern(pattern));
            LocalDate to = LocalDate.parse(toDate, DateTimeFormatter.ofPattern(pattern));
            return getPeriodBetweenDates(from, to);
        } catch (DateTimeParseException dtpe) {
            throw new IllegalArgumentException("Illegal string to parse.", dtpe);
        }
    }

    public int calculateTotalDays(Period period) {
        int days = period.getYears() * 365 + period.getMonths() * 30 + period.getDays();
        return days;
    }

    private Period fullyNormalized(Period period) {
        int periodDays = period.getDays();
        if (periodDays < 30) {
            period = period.normalized();
        } else {
            int months = periodDays / 30;
            int days = periodDays % 30;
            period = period.plusDays((long)days - periodDays);
            period = period.plusMonths(months);
            period = period.normalized();
        }

        return period;
    }

    private boolean isEmpty(String str) {
        return (str == null || str.isEmpty() || str.isBlank());
    }
}
