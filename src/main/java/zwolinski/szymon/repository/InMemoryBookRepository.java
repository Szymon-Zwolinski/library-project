package zwolinski.szymon.repository;

import zwolinski.szymon.Book;

import java.util.*;
import java.util.stream.Collectors;

public class InMemoryBookRepository implements BookRepository{
    Set<Book> books;

    public InMemoryBookRepository(Set<Book> books) {
        this.books = books;
    }

    @Override
    public void addBook(Book book) {
        books.add(book);
    }

    @Override
    public Book findByTitle(String title) {
        return books.stream()
                .filter(book -> Objects.equals(book.getTitle(), title))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void filterByAuthor(String author) {
        List<Book> filteredBooks = books.stream()
                .filter(book -> Objects.equals(book.getAuthor(), author))
                .toList();
        for (Book b: filteredBooks){
            System.out.println(b);
        }
    }
}
