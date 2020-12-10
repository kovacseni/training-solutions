package week07d04;

import java.time.LocalDateTime;

public class Lab {

    private String title;
    private boolean completed;
    private LocalDateTime completedAt;

    public Lab(String title) {
        this.title = title;
        this.completed = false;
        this.completedAt = null;
    }

    public Lab(String title, LocalDateTime completedAt) {
        this.title = title;
        this.completed = true;
        this.completedAt = completedAt;
    }

    public void complete(LocalDateTime dateAndTime) {
        completed = true;
        completedAt = dateAndTime;
    }

    public void complete() {
        completed = true;
        completedAt = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Feladat: " + title + ", készen van: " + completed + ", elkészítés dátuma: " + completedAt;
    }
}
