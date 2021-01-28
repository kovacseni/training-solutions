package clone.timesheet;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class TimeSheetItem {

    private String employee;
    private String project;
    private LocalDateTime from;
    private LocalDateTime to;

    public TimeSheetItem(String employee, String project, LocalDateTime from, LocalDateTime to) {
        this.employee = employee;
        this.project = project;
        this.from = from;
        this.to = to;
    }

    public TimeSheetItem(TimeSheetItem timeSheetItem) {
        this.employee = timeSheetItem.employee;
        this.project = timeSheetItem.project;
        this.from = timeSheetItem.from;
        this.to = timeSheetItem.to;
    }

    public String getEmployee() {
        return employee;
    }

    public String getProject() {
        return project;
    }

    public LocalDateTime getFrom() {
        return from;
    }

    public LocalDateTime getTo() {
        return to;
    }

    public static TimeSheetItem withDifferentDay(TimeSheetItem timeSheetItem, LocalDate localDate) {
        LocalTime localTimeFrom = timeSheetItem.from.toLocalTime();
        LocalTime localTimeTo = timeSheetItem.to.toLocalTime();
        LocalDateTime newFrom = LocalDateTime.of(localDate, localTimeFrom);
        LocalDateTime newTo = LocalDateTime.of(localDate, localTimeTo);
        TimeSheetItem newTimeSheetItem = new TimeSheetItem(timeSheetItem.employee, timeSheetItem.project, newFrom, newTo);

        return new TimeSheetItem(newTimeSheetItem);
    }
}
