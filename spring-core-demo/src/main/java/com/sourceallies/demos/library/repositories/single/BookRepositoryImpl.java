package com.sourceallies.demos.library.repositories.single;

import com.sourceallies.demos.library.domain.Book;

import java.util.ArrayList;
import java.util.List;

public class BookRepositoryImpl implements com.sourceallies.demos.library.repositories.BookRepository {

    private final List<Book> books;

    public BookRepositoryImpl(List<Book> books) {
        this.books = books;
    }

    @Override
    public List<Book> getAll() {
        return new ArrayList<>(this.books);
    }
}
