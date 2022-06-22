package zwolinski.szymon;

import zwolinski.szymon.service.LibraryService;

public class Main {
    final static LibraryService libraryService = new LibraryService();

    public static void main(String[] args){
        libraryService.runService();
    }
}
