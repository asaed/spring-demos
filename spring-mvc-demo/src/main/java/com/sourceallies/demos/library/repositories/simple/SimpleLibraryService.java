package com.sourceallies.demos.library.repositories.simple;

import com.sourceallies.demos.library.domain.Library;
import com.sourceallies.demos.library.repositories.LibraryService;
import org.apache.log4j.Logger;

public class SimpleLibraryService implements LibraryService {
    private static final Logger LOG = Logger.getLogger(SimpleLibraryService.class);

    private final Library library;
    private final SimpleBookRepository bookRepository;
    private final SimpleAuthorRepository authorRepository;

    public SimpleLibraryService(Library library,
                                SimpleBookRepository bookRepository,
                                SimpleAuthorRepository authorRepository) {
        LOG.debug("constructing new instance");
        this.library = library;
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public Library getLibrary() {
        return library;
    }

    @Override
    public SimpleBookRepository getBookRepository() {
        return bookRepository;
    }

    @Override
    public SimpleAuthorRepository getAuthorRepository() {
        return authorRepository;
    }
}
