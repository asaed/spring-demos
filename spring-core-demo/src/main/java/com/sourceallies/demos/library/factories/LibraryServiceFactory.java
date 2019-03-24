package com.sourceallies.demos.library.factories;

import com.sourceallies.demos.library.domain.Library;
import com.sourceallies.demos.library.loader.LibraryDataLoader;
import org.apache.log4j.Logger;

public class LibraryServiceFactory {

    private static final Logger LOG = Logger.getLogger(LibraryServiceFactory.class);

//    public static SimpleLibraryService createSimpleLibraryService(String libraryBasePath){
//        LOG.debug("constructing a SimpleLibraryService");
//        Library library = LibraryDataLoader.loadLibrary(libraryBasePath);
//        SimpleBookRepository bookRepository = BookRepositoryFactory.createSimpleBookRepository(libraryBasePath);
//        SimpleAuthorRepository simpleAuthorRepository = AuthorRepositoryFactory.createSimpleAuthorRepository(libraryBasePath);
//        return new SimpleLibraryService(library, bookRepository, simpleAuthorRepository);
//    }

    // This method can be deleted completely. We are keeping it just to show how we can use it with Spring
    public static Library createLibrary(String libraryBasePath){
        return (new LibraryDataLoader()).loadLibrary(libraryBasePath);
    }

}
