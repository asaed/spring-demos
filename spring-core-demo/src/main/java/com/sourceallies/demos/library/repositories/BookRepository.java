package com.sourceallies.demos.library.repositories;

import com.sourceallies.demos.library.domain.Book;

import java.util.List;

public interface BookRepository {
    List<Book> getAll();
}
