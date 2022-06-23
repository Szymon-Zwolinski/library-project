package zwolinski.szymon;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BookTest {
    @BeforeEach
    public void setup(){
    }

    @Test
    public void bookConstructor_incorrectBook_throwIllegalArgumentException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Book(null, null, null));
    }

    @Test
    public void bookConstructor_incorrectYearFormat_throwIllegalArgumentException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Book("The Great Gatsby", "Francis Scott Fitxgerald", "20000"));
    }
}
