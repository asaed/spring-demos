package com.sourceallies.demos.library.factories;

import com.sourceallies.demos.library.domain.Library;
import com.sourceallies.demos.library.loader.LibraryDataLoader;
import com.sourceallies.demos.library.repositories.AuthorRepository;
import com.sourceallies.demos.library.repositories.BookRepository;
import com.sourceallies.demos.library.repositories.LibraryRepository;
import org.apache.log4j.Logger;

public class LibraryRepositoryFactory {

    private static final Logger LOG = Logger.getLogger(LibraryRepositoryFactory.class);

    public LibraryRepository createLibraryRepository(String libraryBasePath){
        LOG.debug("constructing a LibraryRepository");
        Library library = (new LibraryDataLoader()).loadLibrary(libraryBasePath);
        BookRepository bookRepository = (new BookRepositoryFactory()).createBookRepository(libraryBasePath);
        AuthorRepository authorRepository = (new AuthorRepositoryFactory()).createAuthorRepository(libraryBasePath);
        return new LibraryRepository(library, bookRepository, authorRepository);
    }
}
