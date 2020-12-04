package defaultconstructor.date;

public class SimpleDate {

    private int year;
    private int month;
    private int day;

    public void setDate(int year, int month, int day) {
        if (yearIsValid(year, month, day)) {
            this.year = year;
        }
        if (monthIsValid(year, month, day)) {
            this.month = month;
        }
        if (dayIsValid(year, month, day)) {
            this.day = day;
        }
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    private boolean yearIsValid(int year, int month, int day) {
        boolean valid = true;
        if (year < 1900) {
            valid = false;
            throw new IllegalArgumentException(exceptionString(year, month, day));
        }
        return valid;
    }

    private boolean monthIsValid(int year, int month, int day) {
        boolean valid = true;
        if (month < 1 || month > 12) {
            valid = false;
            throw new IllegalArgumentException(exceptionString(year, month, day));
        }
        return valid;
    }

    private boolean dayIsValid(int year, int month, int day) {
        boolean valid = true;
        if (day < 1) {
            valid = false;
            throw new IllegalArgumentException(exceptionString(year, month, day));
        } else {
            switch (month) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    if (day > 31) {
                        valid = false;
                        throw new IllegalArgumentException(exceptionString(year, month, day));
                    }
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    if (day > 30) {
                        valid = false;
                        throw new IllegalArgumentException(exceptionString(year, month, day));
                    }
                    break;
                case 2:
                    if (year == 1900 && day > 28) {
                        valid = false;
                        throw new IllegalArgumentException(exceptionString(year, month, day));
                    } else if (year != 1900 && year % 4 == 0 && day > 29) {
                        valid = false;
                        throw new IllegalArgumentException(exceptionString(year, month, day));
                    } else if (year % 4 != 0 && day > 28) {
                        valid = false;
                        throw new IllegalArgumentException(exceptionString(year, month, day));
                    }
                    break;
                }
            }
        return valid;
    }

    private String exceptionString(int year, int month, int day) {
        StringBuilder sb = new StringBuilder("One or more given parameter cannot be applied! ");
        sb.append(year).append(", ").append(month).append(", ").append(day);
        return sb.toString();
    }
}

/* javap SimpleDate.class parancsra a következőt irta ki:

Compiled from "SimpleDate.java"
public class defaultconstructor.date.SimpleDate {
  public defaultconstructor.date.SimpleDate();
  public void setDate(int, int, int);
  public int getYear();
  public int getMonth();
  public int getDay();
}

 */
