package com.sourceallies.demos.library.repositories.aggregation;

import com.sourceallies.demos.library.domain.Book;
import com.sourceallies.demos.library.repositories.BookRepository;
import com.sourceallies.demos.library.repositories.simple.SimpleBookRepository;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class AggregatingBookRepository implements BookRepository {

    private final List<SimpleBookRepository> bookRepositories;

    public AggregatingBookRepository(List<SimpleBookRepository> bookRepositories) {
        this.bookRepositories = bookRepositories;
    }

    @Override
    public List<Book> getAll() {
        return bookRepositories.stream()
                .map(SimpleBookRepository::getAll)
                .flatMap(Collection::stream)
                .distinct()
                .collect(Collectors.toList());
    }
}
