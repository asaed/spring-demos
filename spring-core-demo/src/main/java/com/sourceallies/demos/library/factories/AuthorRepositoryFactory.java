package com.sourceallies.demos.library.factories;

import org.apache.log4j.Logger;

public class AuthorRepositoryFactory {

    private static final Logger LOG = Logger.getLogger(AuthorRepositoryFactory.class);

//    public static SimpleAuthorRepository createSimpleAuthorRepository(String libraryBasePath){
//        LOG.debug("constructing an SimpleAuthorRepository");
//        SimpleBookRepository bookRepository = BookRepositoryFactory.createSimpleBookRepository(libraryBasePath);
//        return new SimpleAuthorRepository(bookRepository);
//    }

//    public static AggregatingAuthorRepository createAggregatingAuthorRepository(AggregatingBookRepository aggregatingBookRepository) {
//        LOG.debug("constructing a AggregatingAuthorRepository");
//        return new AggregatingAuthorRepository(aggregatingBookRepository);
//    }
}
