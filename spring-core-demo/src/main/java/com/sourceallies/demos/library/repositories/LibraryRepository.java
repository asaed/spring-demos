package com.sourceallies.demos.library.repositories;

import com.sourceallies.demos.library.domain.Library;
import com.sourceallies.demos.library.loader.LibraryDataLoader;

public class LibraryRepository {

    private Library library;
    private BookRepository bookRepository;

    public LibraryRepository(String libraryBasePath) {
        this.library = (new LibraryDataLoader()).loadLibrary(libraryBasePath);
        this.bookRepository = new BookRepository(libraryBasePath);
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    public BookRepository getBookRepository() {
        return bookRepository;
    }

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
}
