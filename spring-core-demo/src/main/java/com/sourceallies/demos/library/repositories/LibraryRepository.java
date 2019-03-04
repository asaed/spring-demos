package com.sourceallies.demos.library.repositories;

import com.sourceallies.demos.library.domain.Library;
import com.sourceallies.demos.library.repositories.single.AuthorRepositoryImpl;
import com.sourceallies.demos.library.repositories.single.BookRepositoryImpl;
import com.sourceallies.demos.library.repositories.single.GenreRepositoryImpl;

public interface LibraryRepository {
    Library getLibrary();

    BookRepositoryImpl getBookRepository();

    AuthorRepositoryImpl getAuthorRepository();

    GenreRepositoryImpl getGenreRepository();
}
