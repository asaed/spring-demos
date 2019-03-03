package com.sourceallies.demos.library.repositories;

import com.sourceallies.demos.library.domain.Book;

import java.util.ArrayList;
import java.util.List;

public class BookRepository {

    private final List<Book> books;

    public BookRepository(List<Book> books){
        this.books = books;
    }

    public List<Book> getAll() {
        return new ArrayList<>(this.books);
    }
}
