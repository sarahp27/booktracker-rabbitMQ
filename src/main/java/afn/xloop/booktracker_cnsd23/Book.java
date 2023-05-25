package afn.xloop.booktracker_cnsd23;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Book {
    @Id
    private Integer id;
    private String title;
    private String author;
    private int year;
    private int pages;

    public Book() {}

    public Book(int id, String title, String author, int year, int pages) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
        this.pages = pages;
    }
}
