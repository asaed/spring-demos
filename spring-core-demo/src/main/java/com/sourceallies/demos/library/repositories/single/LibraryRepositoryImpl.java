package com.sourceallies.demos.library.repositories.single;

import com.sourceallies.demos.library.domain.Library;

public class LibraryRepositoryImpl implements com.sourceallies.demos.library.repositories.LibraryRepository {

    private final Library library;
    private final BookRepositoryImpl bookRepository;
    private final AuthorRepositoryImpl authorRepository;
    private final GenreRepositoryImpl genreRepository;

    public LibraryRepositoryImpl(Library library,
                                 BookRepositoryImpl bookRepository,
                                 AuthorRepositoryImpl authorRepository,
                                 GenreRepositoryImpl genreRepository) {
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
    public BookRepositoryImpl getBookRepository() {
        return bookRepository;
    }

    @Override
    public AuthorRepositoryImpl getAuthorRepository() {
        return authorRepository;
    }

    @Override
    public GenreRepositoryImpl getGenreRepository() {
        return genreRepository;
    }
}
