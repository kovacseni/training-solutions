package exceptionclass.course;

public class SimpleTime {

    private int hour;
    private int minute;

    public SimpleTime(int hour,int minute) {
        if (hour < 0 || hour > 23) {
            throw new InvalidTimeException("Hour is invalid (0-23)");
        }
        if (minute < 0 || minute > 59) {
            throw new InvalidTimeException("Minute is invalid (0-59)");
        }

        this.hour = hour;
        this.minute = minute;
    }

    public SimpleTime(String hhmm) {
        if (hhmm == null) {
            throw new InvalidTimeException("Time is null");
        }
        if (hhmm.length() != 5 || hhmm.charAt(2) != ':') {
            throw new InvalidTimeException("Time is not hh:mm");
        }
        try {
            int index = hhmm.indexOf(":");
            this.hour = Integer.parseInt(hhmm.substring(0, index));
            this.minute = Integer.parseInt(hhmm.substring(index + 1));
        } catch (NumberFormatException nfe) {
            throw new InvalidTimeException("Time is not hh:mm");
        }
        if (hour < 0 || hour > 23) {
            throw new InvalidTimeException("Hour is invalid (0-23)");
        }
        if (minute < 0 || minute > 59) {
            throw new InvalidTimeException("Minute is invalid (0-59)");
        }
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d", hour, minute);
    }
}
