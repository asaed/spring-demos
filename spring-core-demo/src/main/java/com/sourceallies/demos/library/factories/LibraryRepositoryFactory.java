package com.sourceallies.demos.library.factories;

import com.sourceallies.demos.library.domain.Library;
import com.sourceallies.demos.library.loader.LibraryDataLoader;
import com.sourceallies.demos.library.repositories.single.AuthorRepositoryImpl;
import com.sourceallies.demos.library.repositories.single.BookRepositoryImpl;
import com.sourceallies.demos.library.repositories.single.GenreRepositoryImpl;
import com.sourceallies.demos.library.repositories.single.LibraryRepositoryImpl;
import org.apache.log4j.Logger;

public class LibraryRepositoryFactory {

    private static final Logger LOG = Logger.getLogger(LibraryRepositoryFactory.class);

    public LibraryRepositoryImpl createLibraryRepositoryImpl(String libraryBasePath){
        LOG.debug("constructing a LibraryRepositoryImpl");
        Library library = (new LibraryDataLoader()).loadLibrary(libraryBasePath);
        BookRepositoryImpl bookRepository = (new BookRepositoryFactory()).createBookRepositoryImpl(libraryBasePath);
        AuthorRepositoryImpl authorRepositoryImpl = (new AuthorRepositoryFactory()).createAuthorRepositoryImpl(libraryBasePath);
        GenreRepositoryImpl genreRepository = (new GenreRepositoryFactory()).createGenreRepositoryImpl(libraryBasePath);
        return new LibraryRepositoryImpl(library, bookRepository, authorRepositoryImpl, genreRepository);
    }
}
