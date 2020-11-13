package week03;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PhoneParserTest {

    @Test
    void testParsePhone() {
        //Given
        PhoneParser parser = new PhoneParser();
        //When
        Phone phone = parser.parsePhone("301234567");
        //Then
        assertEquals("30", phone.getPrefix());
        assertEquals("1234567", phone.getNumber());
        assertEquals("30-1234567", phone.toString());
    }
}
