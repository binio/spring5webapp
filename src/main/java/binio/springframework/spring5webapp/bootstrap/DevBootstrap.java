package binio.springframework.spring5webapp.bootstrap;

import binio.springframework.spring5webapp.model.*;
import binio.springframework.spring5webapp.repositories.AuthorRepository;
import binio.springframework.spring5webapp.repositories.BookRepository;
import binio.springframework.spring5webapp.repositories.PublisherRepository;
import binio.springframework.spring5webapp.repositories.ResultDefinitionRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.UUID;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{

    private final PublisherRepository publisherRepository;
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private ResultDefinitionRepository resultDefinitionRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository,ResultDefinitionRepository resultDefinitionRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
        this.resultDefinitionRepository = resultDefinitionRepository;
    }

    private void initData(){

        UUID resultDefinitionId = UUID.randomUUID();
        UUID resultPromptId = UUID.randomUUID();
        ZonedDateTime resultDefinitionVersion = ZonedDateTime.now();

        ArrayList<ResultPromptWordGroup> resultPromptWordGroups = new ArrayList<>();
        ArrayList<ResultPrompt> prompts = new ArrayList<>();

        ResultPromptWordGroup resultPromptWordGroup = new ResultPromptWordGroup(
                "resultWord",
                "123",
                resultPromptId,
                resultDefinitionVersion,
                resultDefinitionId

        );
        ResultPromptWordGroup resultPromptWordGroup1 = new ResultPromptWordGroup(
                "resultWord-1",
                "123",
                resultPromptId,
                resultDefinitionVersion,
                resultDefinitionId

        );
        resultPromptWordGroups.add(resultPromptWordGroup);
        resultPromptWordGroups.add(resultPromptWordGroup1);

        ResultPrompt prompt = new ResultPrompt(
                resultPromptId,
                resultDefinitionId,
                resultDefinitionVersion,
                "promptLabel",
                resultPromptWordGroups
        );

        prompts.add(prompt);

        ResultDefinition rd = new ResultDefinition(
                resultDefinitionId,
                "name",
                "description",
                prompts,
                resultDefinitionVersion
        );
        Publisher publisher = new Publisher();
        publisher.setName("foo");
        publisherRepository.save(publisher);

        //Eric
        Author eric = new Author("Eric", "Evans");
        Book  ddd = new Book("Domain Driven Design", "1234", publisher);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);


        //Rod
        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "23444", publisher );
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

        //Thomas
        Author thomas = new Author("Thomas", "Biniecki");
        authorRepository.save(thomas);

        //Adam
        Author adam = new Author("Adam", "Binieckiz");
        authorRepository.save(adam);

        resultDefinitionRepository.save(rd);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }
}
