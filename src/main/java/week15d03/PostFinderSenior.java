package week15d03;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PostFinderSenior {

    private List<PostSenior> posts;

    public PostFinderSenior(List<PostSenior> posts) {
        this.posts = posts;
    }

    public List<PostSenior> getPosts() {
        return new ArrayList<>(posts);
    }

    public List<PostSenior> findPosts(String user) {
        return posts.stream()
                .filter(p -> !isEmpty(p.getTitle()))
                .filter(p -> !isEmpty(p.getContent()))
                .filter(p -> p.getDeletedAt().isAfter(LocalDate.now()))
                .filter(p -> p.getPublishedAt().isBefore(LocalDate.now()))
                .filter(p -> p.getOwner().equals(user))
                .collect(Collectors.toList());
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty() || str.isBlank();
    }
}
