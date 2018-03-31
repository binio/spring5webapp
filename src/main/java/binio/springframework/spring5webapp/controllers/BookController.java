package binio.springframework.spring5webapp.controllers;

import binio.springframework.spring5webapp.repositories.BookRepository;
import binio.springframework.spring5webapp.repositories.ResultDefinitionRepository;
import org.springframework.stereotype.Controller;

@Controller
public class BookController {

    private BookRepository bookRepository;
    private ResultDefinitionRepository resultDefinitionRepository;

    public BookController(BookRepository bookRepository, ResultDefinitionRepository rdr) {
        this.bookRepository = bookRepository;
        this.resultDefinitionRepository = rdr;
    }

//    @RequestMapping("/books")
//    String getBooks(Model model) {
//        List<ResultWordGroup> list = new ArrayList();
//        ResultWordGroup rwg1 = new ResultWordGroup(2L, 2L, "po12", "myword");
//        list.add(rwg1);
//        ResultWordGroup rwg2 = new ResultWordGroup(3L, 3L, "po13", "myword");
//        list.add(rwg2);
//        ResultWordGroup rwg3 = new ResultWordGroup(3L, 4L, "po14", "myword");
//        list.add(rwg3);
//        ResultDefinition rd = new ResultDefinition("myDefinition", "myDescription", list);
//        rwg1.setResultDefinition(rd);
//        rwg2.setResultDefinition(rd);
//        rwg3.setResultDefinition(rd);
//        this.resultDefinitionRepository.save(rd);
//
//        model.addAttribute("books", bookRepository.findAll());
//        return "books";
//    }
}
