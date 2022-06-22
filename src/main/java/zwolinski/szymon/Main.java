package zwolinski.szymon;

import zwolinski.szymon.repository.InMemoryClientRepository;
import zwolinski.szymon.service.LibraryService;

import java.sql.SQLOutput;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    final static Set<Client> set = new HashSet<>();
    final static InMemoryClientRepository inMemoryClientRepository = new InMemoryClientRepository(set);
    final static LibraryService libraryService = new LibraryService(inMemoryClientRepository);

    public static void main(String[] args) {
        Main.runService();
    }
    private static void runService(){
        boolean isRunning = true;
        while(isRunning){
            System.out.println("Welcome to library! What do you want to do?\nAdd client (1)\nSearch client by email (4)\nSearch book (4)\nExit application (5)");
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
                    libraryService.add(client);
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
                    System.out.println("Enter book title: ");
                    String title = scanner.next();
                    System.out.println("Searching by book title not implemented yet");
                }
                case 5 -> {
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
