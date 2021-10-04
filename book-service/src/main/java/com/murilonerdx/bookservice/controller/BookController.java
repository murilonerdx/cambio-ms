package com.murilonerdx.bookservice.controller;

import com.murilonerdx.bookservice.model.Book;
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
    public Environment environment;

    @GetMapping(value="/{id}/")
    public Book findBook(
        @PathVariable("id") Long id,
        @PathVariable("currency") String currency
    ){

    }
}
