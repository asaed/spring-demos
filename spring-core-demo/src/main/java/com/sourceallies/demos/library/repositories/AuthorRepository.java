package com.sourceallies.demos.library.repositories;

import com.sourceallies.demos.library.domain.Author;

import java.util.List;

public interface AuthorRepository {
    List<Author> getAll();

    List<Author> getAllByBookCountDescending();
}
