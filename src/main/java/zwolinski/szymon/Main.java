package zwolinski.szymon;

import zwolinski.szymon.repository.InMemoryClientRepository;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Client client1 = new Client("Mark", "Smith", "mark@mail.com");
        Set<Client> set = new HashSet<>();
        InMemoryClientRepository inMemoryClientRepository = new InMemoryClientRepository(set);
        LibraryService libraryService = new LibraryService(inMemoryClientRepository);
        libraryService.add(client1);
        Client searchedClient = new Client("Mark", "Smith", "mark@mail.com");
        System.out.println(libraryService.findByEmail(searchedClient.getEmail()));
        System.out.println(libraryService.findByName(searchedClient.getName(), searchedClient.getSurname() +  " "));
    }
}
