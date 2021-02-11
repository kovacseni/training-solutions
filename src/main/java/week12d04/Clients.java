package week12d04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Clients {

    private List<Client> clients = new ArrayList<>();

    public List<Client> getClients() {
        return new ArrayList<>(clients);
    }

    public void addClient(Client client) {
        clients.add(client);
    }

    public Client findByRegNumber(String regNumber) {
       Client toSearch = new Client(null, regNumber);
       Collections.sort(clients);
       int index = Collections.binarySearch(clients, toSearch);
       if (index < 0) {
           throw new IllegalArgumentException("No such client.");
       }

       return clients.get(index);
    }

    public List<Client> findByName(String name) {
        List<Client> result = clients.stream().filter(c -> c.getName().equals(name)).collect(Collectors.toList());
        return result;
    }
}
