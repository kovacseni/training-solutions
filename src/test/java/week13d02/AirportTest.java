package week13d02;

import org.junit.jupiter.api.Test;
import java.nio.file.Path;
import java.time.LocalTime;
import static org.junit.jupiter.api.Assertions.*;

public class AirportTest {

    @Test
    void readFile() {
        Airport a = new Airport();
        a.readFile(Path.of("src/main/resources/cities.txt"));

        assertEquals(100, a.getFlights().size());
    }

    @Test
    void whatsMore() {
        Airport a = new Airport();
        a.readFile(Path.of("src/main/resources/cities.txt"));

        assertEquals(FlightType.DEPARTURE, a.whatsMore());
    }

    @Test
    void getFlightByNumber() {
        Airport a = new Airport();
        a.readFile(Path.of("src/main/resources/cities.txt"));

        assertEquals("Budapest", a.getFlightByNumber("SW1667").getCity());
        assertEquals(LocalTime.of(9,35), a.getFlightByNumber("MN5047").getTime());
    }

    @Test
    void findFlights() {
        Airport a = new Airport();
        a.readFile(Path.of("src/main/resources/cities.txt"));

        assertEquals(3, a.findFlights("Budapest", FlightType.ARRIVAL).size());
        assertEquals(2, a.findFlights("Moscow", FlightType.DEPARTURE).size());

    }

    @Test
    void getEarliestFlight() {
        Airport a = new Airport();
        a.readFile(Path.of("src/main/resources/cities.txt"));

        assertEquals("FG3210 DEPARTURE Zurich 06:16", a.getEarliestDepartureFlight().toString());
    }
}
