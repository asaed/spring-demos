package com.sourceallies.demos.library.factories;

import com.sourceallies.demos.library.repositories.aggregation.AggregatingBookRepository;
import com.sourceallies.demos.library.repositories.aggregation.AggregatingGenreRepository;
import com.sourceallies.demos.library.repositories.simple.SimpleBookRepository;
import com.sourceallies.demos.library.repositories.simple.SimpleGenreRepository;
import org.apache.log4j.Logger;

public class GenreRepositoryFactory {

    private static final Logger LOG = Logger.getLogger(GenreRepositoryFactory.class);

    public SimpleGenreRepository createGenreRepositoryImpl(String libraryBasePath) {
        LOG.debug("constructing a SimpleGenreRepository");
        SimpleBookRepository bookRepository = (new BookRepositoryFactory()).createBookRepositoryImpl(libraryBasePath);
        return new SimpleGenreRepository(bookRepository);
    }

    public AggregatingGenreRepository createGenreAggregationRepository(AggregatingBookRepository aggregatingBookRepository) {
        LOG.debug("constructing a AggregatingGenreRepository");
        return new AggregatingGenreRepository(aggregatingBookRepository);
    }
}
