package com.sourceallies.demos.library.factories;

import com.sourceallies.demos.library.repositories.BookRepository;
import com.sourceallies.demos.library.repositories.GenreRepository;
import org.apache.log4j.Logger;

public class GenreRepositoryFactory {

    private static final Logger LOG = Logger.getLogger(GenreRepositoryFactory.class);

    public GenreRepository createGenreRepository(String libraryBasePath) {
        LOG.debug("constructing a GenreRepository");
        BookRepository bookRepository = (new BookRepositoryFactory()).createBookRepository(libraryBasePath);
        return new GenreRepository(bookRepository);
    }
}
