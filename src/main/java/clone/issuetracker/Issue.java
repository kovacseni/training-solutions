package clone.issuetracker;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Issue {

    private String name;
    private LocalDateTime time;
    private Status status;
    private List<Comment> comments = new ArrayList<>();

    public Issue(String name, LocalDateTime time, Status status) {
        this.name = name;
        this.time = time;
        this.status = status;
    }

    public Issue(Issue issue, CopyMode copyMode) {
        this.name = issue.name;
        this.time = issue.time;
        this.status = issue.status;

        if (copyMode == CopyMode.WITH_COMMENTS) {
                  List<Comment> newComments = new ArrayList<>();
                  for (Comment c : issue.comments) {
                      newComments.add(new Comment(c));
                  }
            this.comments = newComments;
        }
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public Status getStatus() {
        return status;
    }

    public List<Comment> getComments() {
        return comments;
    }
}
