package com.sourceallies.demos.library.controllers;

import com.sourceallies.demos.library.domain.Book;
import com.sourceallies.demos.library.repositories.aggregation.AggregatingBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private AggregatingBookRepository aggregatingBookRepository;


    @GetMapping("/books")
//    @GetMapping("/books/*")
//    @GetMapping("/books/**")
    @ResponseBody
    public List<Book> getBooks(){
        return aggregatingBookRepository.getAll();
    }


    /***
     * /books matches
     *  - /books
     *  - /books/
     *
     * /books/* matches
     *  - /books/
     *  - /books/foo
     *  - /books/foo/
     *
     * /books/**
     *  - /books
     *  - /books/
     *  - /books/foo
     *  - /books/foo/bar
     *  - /books/foo/bar/bla/blah
     *
     */
}
