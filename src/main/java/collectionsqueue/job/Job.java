package collectionsqueue.job;

public class Job implements Comparable<Job> {

    private int priority;
    private String jobDescription;
    private boolean urgent;

    public Job(int priority, String jobDescription) {
        this.priority = priority;
        this.jobDescription = jobDescription;
        if (priority < 5) {
            this.urgent = true;
        }
    }

    public int getPriority() {
        return priority;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public boolean isUrgent() {
        return urgent;
    }

    @Override
    public int compareTo(Job job) {
        return this.priority - job.priority;
    }
}
