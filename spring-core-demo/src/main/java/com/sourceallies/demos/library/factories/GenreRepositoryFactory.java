package com.sourceallies.demos.library.factories;

import com.sourceallies.demos.library.repositories.aggregation.BookAggregationRepository;
import com.sourceallies.demos.library.repositories.aggregation.GenreAggregationRepository;
import com.sourceallies.demos.library.repositories.single.BookRepositoryImpl;
import com.sourceallies.demos.library.repositories.single.GenreRepositoryImpl;
import org.apache.log4j.Logger;

public class GenreRepositoryFactory {

    private static final Logger LOG = Logger.getLogger(GenreRepositoryFactory.class);

    public GenreRepositoryImpl createGenreRepositoryImpl(String libraryBasePath) {
        LOG.debug("constructing a GenreRepositoryImpl");
        BookRepositoryImpl bookRepository = (new BookRepositoryFactory()).createBookRepositoryImpl(libraryBasePath);
        return new GenreRepositoryImpl(bookRepository);
    }

    public GenreAggregationRepository createGenreAggregationRepository(BookAggregationRepository bookAggregationRepository) {
        LOG.debug("constructing a GenreAggregationRepository");
        return new GenreAggregationRepository(bookAggregationRepository);
    }
}
