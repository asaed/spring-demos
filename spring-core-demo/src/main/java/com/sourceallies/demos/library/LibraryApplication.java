package com.sourceallies.demos.library;


import com.sourceallies.demos.library.domain.Author;
import com.sourceallies.demos.library.domain.Genre;
import com.sourceallies.demos.library.factories.AuthorRepositoryFactory;
import com.sourceallies.demos.library.factories.BookRepositoryFactory;
import com.sourceallies.demos.library.factories.GenreRepositoryFactory;
import com.sourceallies.demos.library.factories.LibraryRepositoryFactory;
import com.sourceallies.demos.library.repositories.LibraryService;
import com.sourceallies.demos.library.repositories.aggregation.AggregatingAuthorRepository;
import com.sourceallies.demos.library.repositories.aggregation.AggregatingBookRepository;
import com.sourceallies.demos.library.repositories.aggregation.AggregatingGenreRepository;
import com.sourceallies.demos.library.repositories.simple.SimpleBookRepository;
import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LibraryApplication {
    private static final Logger LOG = Logger.getLogger(LibraryApplication.class);

    public static void main(String[] args) {
        try {
            LOG.debug("=========================");
            LOG.debug("Initializing application");
            LibraryService sauLibrary = (new LibraryRepositoryFactory()).createLibraryRepositoryImpl("sau");
            LibraryService centralLibrary = (new LibraryRepositoryFactory()).createLibraryRepositoryImpl("central");
            LibraryService franklinLibrary = (new LibraryRepositoryFactory()).createLibraryRepositoryImpl("franklin");

            List<LibraryService> libraryRepositories = Arrays.asList(sauLibrary, centralLibrary, franklinLibrary);
            List<SimpleBookRepository> bookRepositories = libraryRepositories.stream().map(libraryService -> libraryService.getBookRepository()).collect(Collectors.toList());

            AggregatingBookRepository aggregatingBookRepository = (new BookRepositoryFactory()).createBookAggregationRepository(bookRepositories);
            AggregatingAuthorRepository aggregatingAuthorRepository = (new AuthorRepositoryFactory()).createAuthorAggregationRepository(aggregatingBookRepository);
            AggregatingGenreRepository genreAggregationRepository = (new GenreRepositoryFactory()).createGenreAggregationRepository(aggregatingBookRepository);
            LOG.debug("Initializing finished");

            LOG.info("Welcome to the Library Console App");
            LOG.info("=========================");
            LOG.info(String.format("App has %d libraries", libraryRepositories.size()));
            for (LibraryService libraryService : libraryRepositories){
                String libraryName = libraryService.getLibrary().getName();
                LOG.info((String.format("Library '%s' has %d Books available", libraryName, libraryService.getBookRepository().getAll().size())));
                LOG.info((String.format("Library '%s' from %d Authors", libraryName, libraryService.getAuthorRepository().getAll().size())));
                LOG.info((String.format("Library '%s' covering %d Genres", libraryName, libraryService.getGenreRepository().getAll().size())));
                Author topAuthor = libraryService.getAuthorRepository().getAllByBookCountDescending().get(0);
                LOG.info(String.format("Library '%s' top author: '%s'", libraryName, topAuthor));
                Genre topGenre = libraryService.getGenreRepository().getAllByBookCountDescending().get(0);
                LOG.info(String.format("Library '%s' top genre: '%s'", libraryName, topGenre));
            }


            LOG.info("=========================");
            LOG.info("Aggregated info");
            LOG.info((String.format("On aggregate we have %d Books available", aggregatingBookRepository.getAll().size())));
            LOG.info((String.format("On aggregate from %d Authors", aggregatingAuthorRepository.getAll().size())));
            LOG.info((String.format("On aggregate covering %d Genres", genreAggregationRepository.getAll().size())));
            Author topAggregateAuthor = aggregatingAuthorRepository.getAllByBookCountDescending().get(0);
            LOG.info(String.format("On aggregate top author: '%s'", topAggregateAuthor));
            Genre topAggregateGenre = genreAggregationRepository.getAllByBookCountDescending().get(0);
            LOG.info(String.format("On aggregate top genre: '%s'", topAggregateGenre));
        } catch (Exception e) {
            LOG.error("Error encountered",  e);
            System.exit(1);
        }
    }
}
