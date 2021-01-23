package timesheet;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Company {

    private List<Employee> employees = new ArrayList<>();
    private List<Project> projects = new ArrayList<>();
    private List<TimeSheetItem> timeSheetItems = new ArrayList<>();

    public Company(InputStream employeesFile, InputStream projectsFile) {
        addEmployee(employeesFile);
        addProject(projectsFile);
    }

    public List<Employee> getEmployees() {
        return new ArrayList<>(employees);
    }

    public List<Project> getProjects() {
        return new ArrayList<>(projects);
    }

    public void addTimeSheetItem(Employee employee, Project project, LocalDateTime beginDate, LocalDateTime endDate) {
        timeSheetItems.add(new TimeSheetItem(employee, project, beginDate, endDate));
    }

    public List<ReportLine> calculateProjectByNameYearMonth(String employeeName, int year, int month) {
        List<ReportLine> reports = new ArrayList<>();
        for (Project p : projects) {
            long sum = getHoursByEmployeeProject(p, employeeName, year, month);
            reports.add(new ReportLine(p, sum));
            }
        return reports;
    }

    public void printToFile(String employeeName, int year, int month, Path path) {
        List<ReportLine> reports = calculateProjectByNameYearMonth(employeeName, year, month);
        List<ReportLine> reportsToWrite = getReportsToWrite(reports);
        String monthNumber = getMonthNumber(month);
        int workedTime = getWorkedTime(reportsToWrite);

        try (BufferedWriter bw = Files.newBufferedWriter(path)) {
            bw.write(employeeName + "\t");
            bw.write(year + "-" + monthNumber + "\t");
            bw.write(workedTime + "\n");

            for (ReportLine r : reportsToWrite) {
                bw.write(r.getProject().getName() + "\t");
                bw.write((int)r.getTime() + "\n");
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not write file.", ioe);
        }
    }

    private void addEmployee(InputStream is) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] name = line.split(" ");
                employees.add(new Employee(name[0], name[1]));
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file.");
        }
    }

    private void addProject(InputStream is) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            String line;
            while ((line = br.readLine()) != null) {
                projects.add(new Project(line));
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file.");
        }
    }

    private List<TimeSheetItem> getTimeSheetItemsByEmployeeYearMonth(String employeeName, int year, int month) {
        List<TimeSheetItem> timeSheetItemsByEmployeeYearMonth = new ArrayList<>();
        boolean listItemAdded = false;
        for (TimeSheetItem t : timeSheetItems) {

            String foundEmployeeName = t.getEmployee().getName();
            int foundEmployeeYear = t.getBeginDate().getYear();
            int foundEmployeeMonth = t.getBeginDate().getMonthValue();

            if (foundEmployeeName.equals(employeeName) && foundEmployeeYear == year && foundEmployeeMonth == month) {
                timeSheetItemsByEmployeeYearMonth.add(t);
                listItemAdded = true;
            }
        }
        if (!listItemAdded) {
            throw new IllegalArgumentException("Employee works not in the company!");
        }
        return timeSheetItemsByEmployeeYearMonth;
    }

    private long getHoursByEmployeeProject(Project p, String employeeName, int year, int month) {
        List<TimeSheetItem> timeSheetItemsByEmployeeYearMonth = getTimeSheetItemsByEmployeeYearMonth(employeeName, year, month);
        long sum = 0L;
        for (TimeSheetItem t : timeSheetItemsByEmployeeYearMonth) {
            if (p.getName().equals(t.getProject().getName())) {
                sum += t.hoursBetweenDates();
            }
        }
        return sum;
    }

    private List<ReportLine> getReportsToWrite(List<ReportLine> reports) {
        List<ReportLine> reportsToWrite = new ArrayList<>();
        for (ReportLine r : reports) {
            if (r.getTime() > 0) {
                reportsToWrite.add(r);
            }
        }
        return reportsToWrite;
    }

    private String getMonthNumber(int month) {
        if (month < 10) {
            return "0" + month;
        } else {
            return Integer.toString(month);
        }
    }

    private int getWorkedTime(List<ReportLine> reportsToWrite) {
        int workedTime = 0;
        for (ReportLine r : reportsToWrite) {
            workedTime += (int)r.getTime();
        }
        return workedTime;
    }
}
