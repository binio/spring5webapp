package binio.springframework.spring5webapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String publisher;
    private String isbn;

    public Book() {
    }

    public Book(String title, String publisher, String isbn) {
        this.title = title;
        this.publisher = publisher;
        this.isbn = isbn;
    }
}
