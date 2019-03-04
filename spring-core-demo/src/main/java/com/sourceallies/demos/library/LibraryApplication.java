package com.sourceallies.demos.library;


import com.sourceallies.demos.library.domain.Author;
import com.sourceallies.demos.library.domain.Genre;
import com.sourceallies.demos.library.factories.AuthorRepositoryFactory;
import com.sourceallies.demos.library.factories.BookRepositoryFactory;
import com.sourceallies.demos.library.factories.GenreRepositoryFactory;
import com.sourceallies.demos.library.factories.LibraryRepositoryFactory;
import com.sourceallies.demos.library.repositories.AuthorRepository;
import com.sourceallies.demos.library.repositories.BookRepository;
import com.sourceallies.demos.library.repositories.GenreRepository;
import com.sourceallies.demos.library.repositories.LibraryRepository;
import com.sourceallies.demos.library.repositories.aggregation.AuthorAggregationRepository;
import com.sourceallies.demos.library.repositories.aggregation.BookAggregationRepository;
import com.sourceallies.demos.library.repositories.aggregation.GenreAggregationRepository;
import com.sourceallies.demos.library.repositories.single.AuthorRepositoryImpl;
import com.sourceallies.demos.library.repositories.single.BookRepositoryImpl;
import com.sourceallies.demos.library.repositories.single.GenreRepositoryImpl;
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
            LibraryRepository sauLibrary = (new LibraryRepositoryFactory()).createLibraryRepositoryImpl("sau");
            LibraryRepository centralLibrary = (new LibraryRepositoryFactory()).createLibraryRepositoryImpl("central");
            LibraryRepository franklinLibrary = (new LibraryRepositoryFactory()).createLibraryRepositoryImpl("franklin");

            List<LibraryRepository> libraryRepositories = Arrays.asList(sauLibrary, centralLibrary, franklinLibrary);
            List<BookRepositoryImpl> bookRepositories = libraryRepositories.stream().map(libraryRepository -> libraryRepository.getBookRepository()).collect(Collectors.toList());

            BookAggregationRepository bookAggregationRepository = (new BookRepositoryFactory()).createBookAggregationRepository(bookRepositories);
            AuthorAggregationRepository authorAggregationRepository = (new AuthorRepositoryFactory()).createAuthorAggregationRepository(bookAggregationRepository);
            GenreAggregationRepository genreAggregationRepository = (new GenreRepositoryFactory()).createGenreAggregationRepository(bookAggregationRepository);
            LOG.debug("Initializing finished");

            LOG.info("Welcome to the Library Console App");
            LOG.info("=========================");
            LOG.info(String.format("App has %d libraries", libraryRepositories.size()));
            for (LibraryRepository libraryRepository: libraryRepositories){
                String libraryName = libraryRepository.getLibrary().getName();
                LOG.info((String.format("Library '%s' has %d Books available", libraryName, libraryRepository.getBookRepository().getAll().size())));
                LOG.info((String.format("Library '%s' from %d Authors", libraryName, libraryRepository.getAuthorRepository().getAll().size())));
                LOG.info((String.format("Library '%s' covering %d Genres", libraryName, libraryRepository.getGenreRepository().getAll().size())));
                Author topAuthor = libraryRepository.getAuthorRepository().getAllByBookCountDescending().get(0);
                LOG.info(String.format("Library '%s' top author: '%s'", libraryName, topAuthor));
                Genre topGenre = libraryRepository.getGenreRepository().getAllByBookCountDescending().get(0);
                LOG.info(String.format("Library '%s' top genre: '%s'", libraryName, topGenre));
            }


            LOG.info("=========================");
            LOG.info("Aggregated info");
            LOG.info((String.format("On aggregate we have %d Books available", bookAggregationRepository.getAll().size())));
            LOG.info((String.format("On aggregate from %d Authors", authorAggregationRepository.getAll().size())));
            LOG.info((String.format("On aggregate covering %d Genres", genreAggregationRepository.getAll().size())));
            Author topAggregateAuthor = authorAggregationRepository.getAllByBookCountDescending().get(0);
            LOG.info(String.format("On aggregate top author: '%s'", topAggregateAuthor));
            Genre topAggregateGenre = genreAggregationRepository.getAllByBookCountDescending().get(0);
            LOG.info(String.format("On aggregate top genre: '%s'", topAggregateGenre));
        } catch (Exception e) {
            LOG.error("Error encountered",  e);
            System.exit(1);
        }
    }
}
