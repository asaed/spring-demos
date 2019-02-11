package com.sourceallies.demos.library.repositories;

import com.sourceallies.demos.library.domain.Book;
import com.sourceallies.demos.library.loader.LibraryDataLoader;

import java.util.ArrayList;
import java.util.List;

public class BookRepository {

    private List<Book> books;

    public BookRepository(String libraryBasePath) {
        this.books = (new LibraryDataLoader()).loadBooks(libraryBasePath);
    }

    public List<Book> getAll() {
        return new ArrayList<>(this.books);
    }
}
