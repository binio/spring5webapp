package binio.springframework.spring5webapp.bootstrap;

import binio.springframework.spring5webapp.model.Author;
import binio.springframework.spring5webapp.model.Book;
import binio.springframework.spring5webapp.repositories.AuthorRepository;
import binio.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    private void initData(){

        Author authorM = new Author("Mark","Evans");
        Book bookOne = new Book("Programming in JAVA", "AHGA0191817", "Manning");

        authorM.getBooks().add(bookOne);
        bookOne.getAuthors().add(authorM);

        authorRepository.save(authorM);
        bookRepository.save(bookOne);

        Author authorA = new Author("Adam","Evans");
        Book bookTwo = new Book("Programming in C++", "AHGA0100017", "Manning");

        authorA.getBooks().add(bookTwo);
        bookTwo.getAuthors().add(authorA);

        authorRepository.save(authorA);
        bookRepository.save(bookTwo);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }
}
