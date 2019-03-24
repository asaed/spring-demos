package com.sourceallies.demos.library.factories;

import com.sourceallies.demos.library.domain.Library;
import com.sourceallies.demos.library.loader.LibraryDataLoader;
import com.sourceallies.demos.library.repositories.simple.SimpleAuthorRepository;
import com.sourceallies.demos.library.repositories.simple.SimpleBookRepository;
import com.sourceallies.demos.library.repositories.simple.SimpleLibraryService;
import org.apache.log4j.Logger;

public class LibraryServiceFactory {

    private static final Logger LOG = Logger.getLogger(LibraryServiceFactory.class);

    public static SimpleLibraryService createSimpleLibraryService(String libraryBasePath){
        LOG.debug("constructing a SimpleLibraryService");
        Library library = LibraryDataLoader.loadLibrary(libraryBasePath);
        SimpleBookRepository bookRepository = BookRepositoryFactory.createSimpleBookRepository(libraryBasePath);
        SimpleAuthorRepository simpleAuthorRepository = AuthorRepositoryFactory.createSimpleAuthorRepository(libraryBasePath);
        return new SimpleLibraryService(library, bookRepository, simpleAuthorRepository);
    }

}
