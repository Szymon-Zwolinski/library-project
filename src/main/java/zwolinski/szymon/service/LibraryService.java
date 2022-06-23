package zwolinski.szymon.service;

import zwolinski.szymon.Book;
import zwolinski.szymon.Client;
import zwolinski.szymon.repository.BookRepository;
import zwolinski.szymon.repository.ClientRepository;
import zwolinski.szymon.repository.InMemoryBookRepository;
import zwolinski.szymon.repository.InMemoryClientRepository;

import java.util.HashSet;
import java.util.Scanner;

public class LibraryService {
    final private ClientRepository clientRepository;
    final private BookRepository bookRepository;

    public LibraryService() {
        this.clientRepository = new InMemoryClientRepository(new HashSet<Client>());
        this.bookRepository = new InMemoryBookRepository(new HashSet<Book>());
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

    public void runService(){
        boolean isRunning = true;
        while(isRunning){
            System.out.println("Welcome to library! What do you want to do?\n" +
                    "Add client (1)\n" +
                    "Search client by email (2)\n" +
                    "Search client by name (3)\n" +
                    "Add book (4)\n" +
                    "Search book (5)\n" +
                    "Filter books by author (6)\n" +
                    "Exit application (7)");
            Scanner scanner = new Scanner(System.in);
            int option = scanner.nextInt();

            switch (option){
                case 1 -> {
                    System.out.println("Enter name: ");
                    String name = scanner.next();
                    System.out.println("Enter surname: ");
                    String surname = scanner.next();
                    System.out.println("Enter email: ");
                    String email = scanner.next();

                    Client client = new Client(name, surname, email);
                    addClient(client);
                }
                case 2 -> {
                    System.out.println("Enter email: ");
                    String email = scanner.next();
                    System.out.println(findByEmail(email) + "\n");
                }
                case 3 -> {
                    System.out.println("Enter name: ");
                    String name = scanner.next();
                    System.out.println("Enter surname: ");
                    String surname = scanner.next();
                    System.out.println(findByName(name, surname) + "\n");
                }
                case 4 -> {
                    System.out.println("Enter title: ");
                    String title = scanner.next();
                    System.out.println("Enter author: ");
                    String author = scanner.next();
                    System.out.println("Enter release date in format - yyyy: ");
                    String year = scanner.next();

                    Book book = new Book(title, author, year);
                    addBook(book);
                }
                case 5 -> {
                    System.out.println("Enter book title: ");
                    String title = scanner.next();
                    System.out.println(findByTitle(title) + "\n");
                }
                case 6 -> {
                    System.out.println("Enter author: ");
                    String author = scanner.next();
                    filterByAuthor(author);
                }
                case 7 -> {
                    System.out.println("End of an program!\n");
                    isRunning = false;
                }
                default -> {
                    System.out.println("Wrong input!\n");
                }
            }
        }
    }
}
