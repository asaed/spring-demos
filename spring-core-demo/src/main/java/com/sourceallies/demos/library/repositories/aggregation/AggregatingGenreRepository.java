package com.sourceallies.demos.library.repositories.aggregation;

import com.sourceallies.demos.library.domain.Genre;
import com.sourceallies.demos.library.repositories.GenreRepository;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AggregatingGenreRepository implements GenreRepository {
    private final AggregatingBookRepository aggregatingBookRepository;

    public AggregatingGenreRepository(AggregatingBookRepository aggregatingBookRepository) {
        this.aggregatingBookRepository = aggregatingBookRepository;
    }

    @Override
    public List<Genre> getAll() {
        List<Genre> genres = this.aggregatingBookRepository.getAll()
                .stream()
                .map(book -> book.getGenres())
                .flatMap(genreNames -> genreNames.stream())
                .distinct()
                .map(genreName -> {
                    Genre genre = new Genre();
                    genre.setName(genreName);
                    return genre;
                })
                .collect(Collectors.toList());
        return genres;
    }

    @Override
    public List<Genre> getAllByBookCountDescending() {
        return this.aggregatingBookRepository.getAll()
                .stream()
                .map(book -> book.getGenres())
                .flatMap(genreNames -> genreNames.stream())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().map(entry -> {
                    Genre genre = new Genre();
                    genre.setName(entry.getKey());
                    genre.setBookCount(entry.getValue());
                    return genre;
                })
                .sorted(Comparator.comparingLong(Genre::getBookCount).reversed())
                .collect(Collectors.toList());
    }
}
