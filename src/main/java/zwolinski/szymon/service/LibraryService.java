package zwolinski.szymon.service;

import zwolinski.szymon.Book;
import zwolinski.szymon.Client;
import zwolinski.szymon.repository.BookRepository;
import zwolinski.szymon.repository.ClientRepository;

public class LibraryService {
    private ClientRepository clientRepository;
    private BookRepository bookRepository;

    public LibraryService(ClientRepository clientRepository, BookRepository bookRepository) {
        this.clientRepository = clientRepository;
        this.bookRepository = bookRepository;
    }

    public void addClient(Client client){
        clientRepository.addClient(client);
    }

    public Client findByEmail(String email){
        return clientRepository.findByEmail(email);
    }

    public Client findByName(String name, String surname){
        return clientRepository.findByName(name, surname);
    }

    public void addBook(Book book){
        bookRepository.addBook(book);
    }

    public Book findByTitle(String title){
        return bookRepository.findByTitle(title);
    }

    public void filterByAuthor(String author){
        bookRepository.filterByAuthor(author);
    }
}
