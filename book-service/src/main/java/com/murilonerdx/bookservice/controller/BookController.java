package com.murilonerdx.bookservice.controller;

import com.murilonerdx.bookservice.model.Book;
import com.murilonerdx.bookservice.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("book-service")
public class BookController {

    @Autowired
    private BookRepository repository;

    @Autowired
    public Environment environment;

    @GetMapping(value="/{id}/{currency}")
    public Book findBook(
        @PathVariable("id") Long id,
        @PathVariable("currency") String currency
    ){
        Book book = repository.getById(id);
        if(book == null) throw new RuntimeException("Book id "+ id + "not found");
        String port = environment.getProperty("server.port");
        book.setEnvironment(port);
        return book;
    }
}
