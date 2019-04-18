package com.sourceallies.demos.library.repositories.simple;

import com.sourceallies.demos.library.domain.Book;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class SimpleBookRepository implements com.sourceallies.demos.library.repositories.BookRepository {
    private static final Logger LOG = Logger.getLogger(SimpleBookRepository.class);

    private final List<Book> books;

    public SimpleBookRepository(List<Book> books) {
        LOG.debug("constructing new instance");
        this.books = books;
    }

    @Override
    public List<Book> getAll() {
        return new ArrayList<>(this.books);
    }
}
