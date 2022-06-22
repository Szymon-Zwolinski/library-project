package zwolinski.szymon.repository;

import zwolinski.szymon.Client;

public interface ClientRepository {
    void addClient(Client client);

    Client findByEmail(String email);

    Client findByName(String name, String surname);
}
