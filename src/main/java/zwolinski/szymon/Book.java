package zwolinski.szymon;

import java.time.Year;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Book {
    private String title;
    private String author;
    private Year releaseDate;

    public Book(String title, String author, String releaseDate) {
        if(title == null || author == null || releaseDate == null){
            throw new IllegalArgumentException("Provided values can't be a null");
        }
        if(!yearIsValid(releaseDate)){
            throw new IllegalArgumentException("Provided year should be in yyyy format");
        }
        this.title = title;
        this.author = author;
        this.releaseDate = Year.parse(releaseDate);
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    private boolean yearIsValid(String year){
        final String datePattern = "^(10|11|12|13|14|15|16|17|18|19|20)[0-9][0-9]";
        final Pattern yearPattern = Pattern.compile(datePattern);
        final Matcher matcher = yearPattern.matcher(year);
        if(matcher.matches()) return true;
        return false;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", releaseDate=" + releaseDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(title, book.title) && Objects.equals(author, book.author) && Objects.equals(releaseDate, book.releaseDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, releaseDate);
    }
}
