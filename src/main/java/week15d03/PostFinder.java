package week15d03;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PostFinder {

    private List<Post> posts;

    public PostFinder(List<Post> posts) {
        this.posts = posts;
    }

    public List<Post> findPosts(String user) {
        List<Post> result = new ArrayList<>();
        for (Post p : posts) {
            boolean userIsOwner = p.getOwner().equals(user);
            boolean publishedIsBefore = p.getPublishedAt().isBefore(LocalDate.now());
            boolean contentIsNotEmpty = p != null || !p.getContent().isEmpty();
            boolean titleIsNotEmpty = p != null || !p.getTitle().isEmpty();

            if (userIsOwner && publishedIsBefore && contentIsNotEmpty && titleIsNotEmpty) {
                result.add(p);
            }
        }
        return result;
    }
}
