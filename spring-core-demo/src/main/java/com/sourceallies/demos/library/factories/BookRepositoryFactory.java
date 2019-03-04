package com.sourceallies.demos.library.factories;

import com.sourceallies.demos.library.domain.Book;
import com.sourceallies.demos.library.loader.LibraryDataLoader;
import com.sourceallies.demos.library.repositories.BookRepository;
import com.sourceallies.demos.library.repositories.aggregation.BookAggregationRepository;
import com.sourceallies.demos.library.repositories.single.BookRepositoryImpl;
import org.apache.log4j.Logger;

import java.util.List;

public class BookRepositoryFactory {

    private static final Logger LOG = Logger.getLogger(BookRepositoryFactory.class);

    public BookRepositoryImpl createBookRepositoryImpl(String libraryBasePath){
        LOG.debug("constructing a BookRepositoryImpl");
        List<Book> books = (new LibraryDataLoader()).loadBooks(libraryBasePath);
        return new BookRepositoryImpl(books);
    }

    public BookAggregationRepository createBookAggregationRepository(List<BookRepositoryImpl> bookRepositories) {
        LOG.debug("constructing a BookAggregationRepository");
        return new BookAggregationRepository(bookRepositories);
    }
}
