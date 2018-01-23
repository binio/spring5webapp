package binio.springframework.spring5webapp.bootstrap;

import binio.springframework.spring5webapp.model.Author;
import binio.springframework.spring5webapp.model.Book;
import binio.springframework.spring5webapp.model.Publisher;
import binio.springframework.spring5webapp.repositories.AuthorRepository;
import binio.springframework.spring5webapp.repositories.BookRepository;
import binio.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{

    private final PublisherRepository publisherRepository;
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    private void initData(){

        Publisher publisherA = new Publisher("Manning");
        Publisher publisherB = new Publisher("Pact");
        publisherRepository.save(publisherA);
        publisherRepository.save(publisherB);


        Author authorM = new Author("Mark","Evans");
        Book bookOne = new Book("Programming in JAVA", "AHGA0191817", publisherA);

        authorM.getBooks().add(bookOne);
        bookOne.getAuthors().add(authorM);

        authorRepository.save(authorM);
        bookRepository.save(bookOne);

        Author authorA = new Author("Adam","Evans");
        Book bookTwo = new Book("Programming in C++", "AHGA0100017", publisherB);

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
