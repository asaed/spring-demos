package com.sourceallies.demos.library.repositories.simple;

import com.sourceallies.demos.library.domain.Library;
import com.sourceallies.demos.library.repositories.LibraryService;

public class SimpleLibraryService implements LibraryService {

    private final Library library;
    private final SimpleBookRepository bookRepository;
    private final SimpleAuthorRepository authorRepository;
    private final SimpleGenreRepository genreRepository;

    public SimpleLibraryService(Library library,
                                SimpleBookRepository bookRepository,
                                SimpleAuthorRepository authorRepository,
                                SimpleGenreRepository genreRepository) {
        this.library = library;
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.genreRepository = genreRepository;
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

    @Override
    public SimpleGenreRepository getGenreRepository() {
        return genreRepository;
    }
}
