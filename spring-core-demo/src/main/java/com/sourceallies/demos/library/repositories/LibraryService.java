package com.sourceallies.demos.library.repositories;

import com.sourceallies.demos.library.domain.Library;
import com.sourceallies.demos.library.repositories.simple.SimpleAuthorRepository;
import com.sourceallies.demos.library.repositories.simple.SimpleBookRepository;
import com.sourceallies.demos.library.repositories.simple.SimpleGenreRepository;

public interface LibraryService {
    Library getLibrary();

    SimpleBookRepository getBookRepository();

    SimpleAuthorRepository getAuthorRepository();

    SimpleGenreRepository getGenreRepository();
}
