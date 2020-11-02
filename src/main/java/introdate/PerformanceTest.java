package introdate;

import java.time.LocalDate;
import java.time.LocalTime;

public class PerformanceTest {

    public static void main(String[] args) {

        Performance koncert = new Performance("Queen", LocalDate.of(1989,06,02), LocalTime.of(18,00), LocalTime.of(20,00));

        System.out.println(koncert.getArtist());
        System.out.println(koncert.getDate());
        System.out.println(koncert.getStartTime());
        System.out.println(koncert.getEndTime());

        System.out.println(koncert.getInfo());

    }
}
