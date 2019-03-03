package com.sourceallies.demos.library.factories;

import com.sourceallies.demos.library.repositories.AuthorRepository;
import com.sourceallies.demos.library.repositories.BookRepository;
import org.apache.log4j.Logger;

public class AuthorRepositoryFactory {

    private static final Logger LOG = Logger.getLogger(AuthorRepositoryFactory.class);

    public AuthorRepository createAuthorRepository(String libraryBasePath){
        LOG.debug("constructing an AuthorRepository");
        BookRepository bookRepository = (new BookRepositoryFactory()).createBookRepository(libraryBasePath);
        return new AuthorRepository(bookRepository);
    }
}
