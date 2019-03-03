package com.sourceallies.demos.library.repositories;

import com.sourceallies.demos.library.domain.Library;

public class LibraryRepository {

    private final Library library;
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final GenreRepository genreRepository;

    public LibraryRepository(Library library,
                             BookRepository bookRepository,
                             AuthorRepository authorRepository,
                             GenreRepository genreRepository) {
        this.library = library;
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.genreRepository = genreRepository;
    }

    public Library getLibrary() {
        return library;
    }

    public BookRepository getBookRepository() {
        return bookRepository;
    }

    public AuthorRepository getAuthorRepository() {
        return authorRepository;
    }

    public GenreRepository getGenreRepository() {
        return genreRepository;
    }
}
