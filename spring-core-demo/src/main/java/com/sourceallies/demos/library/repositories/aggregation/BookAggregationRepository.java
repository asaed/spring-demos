package com.sourceallies.demos.library.repositories.aggregation;

import com.sourceallies.demos.library.domain.Book;
import com.sourceallies.demos.library.repositories.BookRepository;
import com.sourceallies.demos.library.repositories.single.BookRepositoryImpl;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class BookAggregationRepository implements BookRepository {

    private final List<BookRepositoryImpl> bookRepositories;

    public BookAggregationRepository(List<BookRepositoryImpl> bookRepositories) {
        this.bookRepositories = bookRepositories;
    }

    @Override
    public List<Book> getAll() {
        return bookRepositories.stream()
                .map(BookRepositoryImpl::getAll)
                .flatMap(Collection::stream)
                .distinct()
                .collect(Collectors.toList());
    }
}
