package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class BooksController {
    @RequestMapping(value="/book")
    public List<Book> getAllBooks() {
        return Arrays.asList(new Book (1, "name1", "author1"));
    }
}
