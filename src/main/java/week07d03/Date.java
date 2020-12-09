package week07d03;

public class Date {

    private final int YEAR;
    private final int MONTH;
    private final int DAY;

    public Date(int year, int month, int day) {
        this.YEAR = year;
        this.MONTH = month;
        this.DAY = day;
    }

    public static Date of(int year, int month, int day) {
        return new Date(year, month, day);
    }

    public Date withYear(int year) {
        return new Date(year, MONTH, DAY);
    }

    public Date withMonth(int month) {
        return new Date(YEAR, month, DAY);
    }

    public Date withDay(int day) {
        return new Date(YEAR, MONTH, day);
    }

    public int getYear() {
        return YEAR;
    }

    public int getMonth() {
        return MONTH;
    }

    public int getDay() {
        return DAY;
    }
}
