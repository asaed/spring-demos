package com.sourceallies.demos.library.repositories;

import com.sourceallies.demos.library.domain.Genre;

import java.util.List;

public interface GenreRepository {
    List<Genre> getAll();

    List<Genre> getAllByBookCountDescending();
}
