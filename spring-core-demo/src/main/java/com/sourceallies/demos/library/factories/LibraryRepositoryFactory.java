package com.sourceallies.demos.library.factories;

import com.sourceallies.demos.library.domain.Library;
import com.sourceallies.demos.library.loader.LibraryDataLoader;
import com.sourceallies.demos.library.repositories.simple.SimpleAuthorRepository;
import com.sourceallies.demos.library.repositories.simple.SimpleBookRepository;
import com.sourceallies.demos.library.repositories.simple.SimpleLibraryService;
import org.apache.log4j.Logger;

public class LibraryRepositoryFactory {

    private static final Logger LOG = Logger.getLogger(LibraryRepositoryFactory.class);

    public SimpleLibraryService createSimpleLibraryService(String libraryBasePath){
        LOG.debug("constructing a SimpleLibraryService");
        Library library = createLibrary(libraryBasePath);
        SimpleBookRepository bookRepository = BookRepositoryFactory.createSimpleBookRepository(libraryBasePath);
        SimpleAuthorRepository simpleAuthorRepository = AuthorRepositoryFactory.createSimpleAuthorRepository(libraryBasePath);
        return new SimpleLibraryService(library, bookRepository, simpleAuthorRepository);
    }

    public static Library createLibrary(String libraryBasePath) {
        return (new LibraryDataLoader()).loadLibrary(libraryBasePath);
    }
}
