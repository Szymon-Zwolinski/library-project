package zwolinski.szymon.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import zwolinski.szymon.Book;
import zwolinski.szymon.service.LibraryService;

public class InMemoryBookRepositoryTest {
    LibraryService libraryService;
    @BeforeEach
    public void setup(){
        libraryService = new LibraryService();
    }
    @Test
    public void addBook_correctBook_addedCorrectly() {
        //given
        Book givenBook = new Book("Harry Potter and the Order of the Phoenix", "J.K. Rowling", "2003");
        //when
        libraryService.addBook(givenBook);
        //then
        Book actualBook = libraryService.findByTitle("Harry Potter and the Order of the Phoenix");
        Book expectedBook = new Book("Harry Potter and the Order of the Phoenix", "J.K. Rowling", "2003");

        Assertions.assertEquals(actualBook, expectedBook);
    }
}
