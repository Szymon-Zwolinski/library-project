package zwolinski.szymon;

import zwolinski.szymon.repository.InMemoryBookRepository;
import zwolinski.szymon.repository.InMemoryClientRepository;
import zwolinski.szymon.service.LibraryService;

import java.sql.SQLOutput;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    final static Set<Client> clients = new HashSet<>();
    final static Set<Book> books = new HashSet<>();
    final static InMemoryClientRepository inMemoryClientRepository = new InMemoryClientRepository(clients);
    final static InMemoryBookRepository inMemoryBookRepository = new InMemoryBookRepository(books);
    final static LibraryService libraryService = new LibraryService(inMemoryClientRepository, inMemoryBookRepository);

    public static void main(String[] args) throws ParseException {
//        Book b1 = new Book("1", "1", new Date("02/02/2000"));
//        Book b2 = new Book("2", "1", new Date("02/02/2010"));
//
//        libraryService.addBook(b1);
//        libraryService.addBook(b2);
//
//        System.out.println(libraryService.findByTitle("1"));
//        libraryService.filterByAuthor("1");

        Main.runService();
    }
    private static void runService() throws ParseException {
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
                    libraryService.addClient(client);
                }
                case 2 -> {
                    System.out.println("Enter email: ");
                    String email = scanner.next();
                    System.out.println(libraryService.findByEmail(email));
                }
                case 3 -> {
                    System.out.println("Enter name: ");
                    String name = scanner.next();
                    System.out.println("Enter surname: ");
                    String surname = scanner.next();
                    System.out.println(libraryService.findByName(name, surname));
                }
                case 4 -> {
                    System.out.println("Enter title: ");
                    String title = scanner.next();
                    System.out.println("Enter author: ");
                    String author = scanner.next();
                    System.out.println("Enter release date in format - mm/dd/yyyy: ");
                    Date date = new Date(scanner.next());

                    Book book = new Book(title, author, date);
                }
                case 5 -> {
                    System.out.println("Enter book title: ");
                    String title = scanner.next();
                    System.out.println(libraryService.findByTitle(title));
                }
                case 6 -> {
                    System.out.println("Enter author: ");
                    String author = scanner.next();
                    libraryService.filterByAuthor(author);
                }
                case 7 -> {
                    System.out.println("End of an program!");
                    isRunning = false;
                }
                default -> {
                    System.out.println("Wrong input!");
                }
            }
        }
    }
}
