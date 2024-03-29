package com.sourceallies.demos.library.factories;

import com.sourceallies.demos.library.domain.Library;
import com.sourceallies.demos.library.loader.LibraryDataLoader;
import com.sourceallies.demos.library.repositories.simple.SimpleAuthorRepository;
import com.sourceallies.demos.library.repositories.simple.SimpleBookRepository;
import com.sourceallies.demos.library.repositories.simple.SimpleGenreRepository;
import com.sourceallies.demos.library.repositories.simple.SimpleLibraryService;
import org.apache.log4j.Logger;

public class LibraryRepositoryFactory {

    private static final Logger LOG = Logger.getLogger(LibraryRepositoryFactory.class);

    public SimpleLibraryService createLibraryRepositoryImpl(String libraryBasePath){
        LOG.debug("constructing a SimpleLibraryService");
        Library library = (new LibraryDataLoader()).loadLibrary(libraryBasePath);
        SimpleBookRepository bookRepository = (new BookRepositoryFactory()).createBookRepositoryImpl(libraryBasePath);
        SimpleAuthorRepository simpleAuthorRepository = (new AuthorRepositoryFactory()).createAuthorRepositoryImpl(libraryBasePath);
        SimpleGenreRepository genreRepository = (new GenreRepositoryFactory()).createGenreRepositoryImpl(libraryBasePath);
        return new SimpleLibraryService(library, bookRepository, simpleAuthorRepository, genreRepository);
    }
}
