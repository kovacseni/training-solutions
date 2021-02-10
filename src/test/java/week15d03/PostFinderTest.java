package week15d03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PostFinderTest {

    @Test
    public void testFindPosts() {
        Post post1 = new Post("Xy", LocalDate.of(2021, 1, 2), "xy", "Józsi");
        Post post2 = new Post("", LocalDate.of(2019, 12, 23), "yz", "Pisti");
        Post post3 = new Post("Yz", LocalDate.of(2022, 2, 22), "yz", "Sanyi");
        Post post4 = new Post("Ab", LocalDate.of(2018, 3, 4), null, "Karcsi");
        Post post5 = new Post("Bc", LocalDate.of(2017, 5, 6), "bc", "Béla");
        Post post6 = new Post("Cd", LocalDate.of(2016, 7, 8), "cd", "   ");
        Post post7 = new Post("De", LocalDate.of(2011, 1, 2), "de", "Józsi");

        List<Post> posts = new ArrayList<>();
        posts.add(post1);
        posts.add(post2);
        posts.add(post3);
        posts.add(post4);
        posts.add(post5);
        posts.add(post6);
        posts.add(post7);

        List<Post> expected = new PostFinder(posts).findPosts("Józsi");

        Assertions.assertEquals(2, expected.size());
        Assertions.assertEquals("De", expected.get(1).getTitle());
        Assertions.assertEquals("xy", expected.get(0).getContent());
    }
}
