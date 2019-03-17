package com.sourceallies.demos.library.repositories.aggregation;

import com.sourceallies.demos.library.domain.Author;
import com.sourceallies.demos.library.repositories.AuthorRepository;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AggregatingAuthorRepository implements AuthorRepository {

    private final AggregatingBookRepository aggregatingBookRepository;

    public AggregatingAuthorRepository(AggregatingBookRepository aggregatingBookRepository) {
        this.aggregatingBookRepository = aggregatingBookRepository;
    }

    @Override
    public List<Author> getAll() {
        List<Author> authors = this.aggregatingBookRepository.getAll()
                .stream()
                .map(book -> book.getAuthors())
                .flatMap(authorNames -> authorNames.stream())
                .distinct()
                .map(authorName -> {
                    Author author = new Author();
                    author.setName(authorName);
                    return author;
                })
                .collect(Collectors.toList());
        return authors;
    }

    @Override
    public List<Author> getAllByBookCountDescending() {
        List<Author> authors = this.aggregatingBookRepository.getAll()
                .stream()
                .map(book -> book.getAuthors())
                .flatMap(authorNames -> authorNames.stream())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .map(entry -> {
                    Author author = new Author();
                    author.setName(entry.getKey());
                    author.setBookCount(entry.getValue());
                    return author;
                })
                .sorted(Comparator.comparingLong(Author::getBookCount).reversed())
                .collect(Collectors.toList());
        return authors;
    }
}
