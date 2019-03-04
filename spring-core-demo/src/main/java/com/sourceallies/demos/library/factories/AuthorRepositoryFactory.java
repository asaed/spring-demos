package com.sourceallies.demos.library.factories;

import com.sourceallies.demos.library.repositories.aggregation.AuthorAggregationRepository;
import com.sourceallies.demos.library.repositories.aggregation.BookAggregationRepository;
import com.sourceallies.demos.library.repositories.single.AuthorRepositoryImpl;
import com.sourceallies.demos.library.repositories.single.BookRepositoryImpl;
import org.apache.log4j.Logger;

public class AuthorRepositoryFactory {

    private static final Logger LOG = Logger.getLogger(AuthorRepositoryFactory.class);

    public AuthorRepositoryImpl createAuthorRepositoryImpl(String libraryBasePath){
        LOG.debug("constructing an AuthorRepositoryImpl");
        BookRepositoryImpl bookRepository = (new BookRepositoryFactory()).createBookRepositoryImpl(libraryBasePath);
        return new AuthorRepositoryImpl(bookRepository);
    }

    public AuthorAggregationRepository createAuthorAggregationRepository(BookAggregationRepository bookAggregationRepository) {
        LOG.debug("constructing a AuthorAggregationRepository");
        return new AuthorAggregationRepository(bookAggregationRepository);
    }
}
