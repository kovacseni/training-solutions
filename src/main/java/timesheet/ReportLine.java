package timesheet;

public class ReportLine {

    private Project project;
    private long time;

    public ReportLine(Project project, long time) {
        if (project == null) {
            throw new IllegalArgumentException("Project name must not be empty!");
        }

        this.project = project;
        this.time = time;
    }

    public Project getProject() {
        return project;
    }

    public long getTime() {
        return time;
    }

    public void addTime(long time) {
        this.time += time;
    }
}
