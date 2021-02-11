package week12d04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClientsFasterSearch {

    private Map<String, Client> clients = new HashMap<>();

    public Map<String, Client> getClients() {
        return new HashMap<>(clients);
    }

    public void addClient(Client client) {
        clients.put(client.getRegNumber(), client);
    }

    public Client findByRegNumber(String regNumber) {
        Client result = clients.get(regNumber);
        if (result == null) {
            throw new IllegalArgumentException("No such client.");
        }
        return result;
    }

    public List<Client> findByName(String name) {
        List<Client> result = new ArrayList<>();
        for (String s : clients.keySet()) {
            if (clients.get(s).getName().equals(name)) {
                result.add(clients.get(s));
            }
        }
        return result;
    }
}
