package com.sourceallies.demos.library.factories;

import com.sourceallies.demos.library.domain.Book;
import com.sourceallies.demos.library.loader.LibraryDataLoader;
import com.sourceallies.demos.library.repositories.BookRepository;
import org.apache.log4j.Logger;

import java.util.List;

public class BookRepositoryFactory {

    private static final Logger LOG = Logger.getLogger(BookRepositoryFactory.class);

    public BookRepository createBookRepository(String libraryBasePath){
        LOG.debug("constructing a BookRepository");
        List<Book> books = (new LibraryDataLoader()).loadBooks(libraryBasePath);
        return new BookRepository(books);
    }
}
