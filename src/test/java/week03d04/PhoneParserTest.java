package week03d04;

import org.junit.jupiter.api.Test;
import week03d04.Phone;
import week03d04.PhoneParser;

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
