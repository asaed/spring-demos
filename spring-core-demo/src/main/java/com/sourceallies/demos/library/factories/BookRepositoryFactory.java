package com.sourceallies.demos.library.factories;

import com.sourceallies.demos.library.domain.Book;
import com.sourceallies.demos.library.loader.LibraryDataLoader;
import com.sourceallies.demos.library.repositories.aggregation.AggregatingBookRepository;
import com.sourceallies.demos.library.repositories.simple.SimpleBookRepository;
import org.apache.log4j.Logger;

import java.util.List;

public class BookRepositoryFactory {

    private static final Logger LOG = Logger.getLogger(BookRepositoryFactory.class);

    public static SimpleBookRepository createSimpleBookRepository(String libraryBasePath){
        LOG.debug("constructing a SimpleBookRepository");
        List<Book> books = (new LibraryDataLoader()).loadBooks(libraryBasePath);
        return new SimpleBookRepository(books);
    }

    public AggregatingBookRepository createAggregatingBookRepository(List<SimpleBookRepository> bookRepositories) {
        LOG.debug("constructing a AggregatingBookRepository");
        return new AggregatingBookRepository(bookRepositories);
    }
}
