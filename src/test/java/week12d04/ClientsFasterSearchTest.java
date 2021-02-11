package week12d04;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ClientsFasterSearchTest {

    ClientsFasterSearch clients = new ClientsFasterSearch();

    @BeforeEach
    public void setUp() {
        clients.addClient(new Client("Kiss József", "1234"));
        clients.addClient(new Client("Nagy Béla", "2345"));
        clients.addClient(new Client("Szép Károly", "3456"));
        clients.addClient(new Client("Kiss József", "4567"));
        clients.addClient(new Client("Szabó Géza", "5678"));
    }

    @Test
    public void testFindByRegNumber() {
        Assertions.assertEquals("Szép Károly", clients.findByRegNumber("3456").getName());
    }

    @Test
    public void testFindByName() {
        List<Client> expected = clients.findByName("Kiss József");
        Assertions.assertEquals(2, expected.size());
        Assertions.assertEquals("1234", expected.get(0).getRegNumber());
        Assertions.assertEquals("4567", expected.get(1).getRegNumber());

    }
}
