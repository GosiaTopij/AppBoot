package com.example.demo.controller;

import com.example.demo.modal.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller
public class BooksController {

    @ResponseBody
    @RequestMapping(value="/book")
    public List<Book> getAllBooks() {
        return Arrays.asList(new Book (1, "name1", "author1"));
    }

    }

