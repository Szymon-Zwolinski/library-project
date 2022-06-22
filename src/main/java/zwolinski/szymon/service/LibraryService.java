package zwolinski.szymon.service;

import zwolinski.szymon.Client;
import zwolinski.szymon.repository.ClientRepository;

public class LibraryService {
    private ClientRepository clientRepository;

    public LibraryService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void add(Client client){
        clientRepository.addClient(client);
    }

    public Client findByEmail(String email){
        return clientRepository.findByEmail(email);
    }

    public Client findByName(String name, String surname){
        return clientRepository.findByName(name, surname);
    }
}
