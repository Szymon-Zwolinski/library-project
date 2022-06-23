package zwolinski.szymon.repository;

import zwolinski.szymon.Client;

import java.util.Objects;
import java.util.Set;

public class InMemoryClientRepository implements ClientRepository {
    private Set<Client> clients;

    public InMemoryClientRepository(Set<Client> clients) {
        this.clients = clients;
    }

    @Override
    public void addClient(Client client) {
        clients.add(client);
    }

    @Override
    public Client findByEmail(String email) {
        return clients.stream()
                .filter(client -> Objects.equals(client.getEmail(), email))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Client findByName(String name, String surname) {
        return clients.stream()
                .filter(client -> Objects.equals(client.getName(), name) && Objects.equals(client.getSurname(), surname))
                .findFirst()
                .orElse(null);
    }
}
