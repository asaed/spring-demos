package com.sourceallies.demos.library.repositories;

import com.sourceallies.demos.library.domain.Author;

import java.util.List;
import java.util.stream.Collectors;

public class AuthorRepository {

    private BookRepository bookRepository;

    public AuthorRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Author> getAll() {

        List<Author> authors = this.bookRepository.getAll()
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
}
