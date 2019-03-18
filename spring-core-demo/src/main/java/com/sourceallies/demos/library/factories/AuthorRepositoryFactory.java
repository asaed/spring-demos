package com.sourceallies.demos.library.factories;

import com.sourceallies.demos.library.repositories.aggregation.AggregatingAuthorRepository;
import com.sourceallies.demos.library.repositories.aggregation.AggregatingBookRepository;
import com.sourceallies.demos.library.repositories.simple.SimpleAuthorRepository;
import com.sourceallies.demos.library.repositories.simple.SimpleBookRepository;
import org.apache.log4j.Logger;

public class AuthorRepositoryFactory {

    private static final Logger LOG = Logger.getLogger(AuthorRepositoryFactory.class);

    public static SimpleAuthorRepository createAuthorRepositoryImpl(String libraryBasePath){
        LOG.debug("constructing an SimpleAuthorRepository");
        SimpleBookRepository bookRepository = (new BookRepositoryFactory()).createBookRepositoryImpl(libraryBasePath);
        return new SimpleAuthorRepository(bookRepository);
    }

    public AggregatingAuthorRepository createAuthorAggregationRepository(AggregatingBookRepository aggregatingBookRepository) {
        LOG.debug("constructing a AggregatingAuthorRepository");
        return new AggregatingAuthorRepository(aggregatingBookRepository);
    }
}
