package zwolinski.szymon.repository;

import zwolinski.szymon.Book;

public interface BookRepository {
    void addBook(Book book);

    Book findByTitle(String title);

    void filterByAuthor(String author);
}
