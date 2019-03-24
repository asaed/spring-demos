package com.sourceallies.demos.library.factories;

import com.sourceallies.demos.library.domain.Book;
import com.sourceallies.demos.library.loader.LibraryDataLoader;
import com.sourceallies.demos.library.repositories.simple.SimpleBookRepository;
import org.apache.log4j.Logger;

import java.util.List;

public class BookRepositoryFactory {

    private static final Logger LOG = Logger.getLogger(BookRepositoryFactory.class);

    // This method can be deleted completely. We are keeping it just to show how we can use it with Spring
    public static SimpleBookRepository createSimpleBookRepository(String libraryBasePath){
        LOG.debug("constructing a SimpleBookRepository");
        List<Book> books = (new LibraryDataLoader()).loadBooks(libraryBasePath);
        return new SimpleBookRepository(books);
    }

//    public static AggregatingBookRepository createAggregatingBookRepository(List<SimpleBookRepository> bookRepositories) {
//        LOG.debug("constructing a AggregatingBookRepository");
//        return new AggregatingBookRepository(bookRepositories);
//    }
}
