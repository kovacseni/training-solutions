package week15d03;

import java.time.LocalDate;

public class PostSenior {

    private String title;
    private LocalDate publishedAt;
    private LocalDate deletedAt;
    private String content;
    private String owner;

    public PostSenior(String title, LocalDate publishedAt, LocalDate deletedAt, String content, String owner) {
        this.title = title;
        this.publishedAt = publishedAt;
        this.deletedAt = deletedAt;
        this.content = content;
        this.owner = owner;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getPublishedAt() {
        return publishedAt;
    }

    public LocalDate getDeletedAt() {
        return deletedAt;
    }

    public String getContent() {
        return content;
    }

    public String getOwner() {
        return owner;
    }
}
