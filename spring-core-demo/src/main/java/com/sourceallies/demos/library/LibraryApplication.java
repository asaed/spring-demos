package com.sourceallies.demos.library;


import com.sourceallies.demos.library.domain.Author;
import com.sourceallies.demos.library.domain.Genre;
import com.sourceallies.demos.library.factories.LibraryRepositoryFactory;
import com.sourceallies.demos.library.repositories.LibraryRepository;
import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.List;

public class LibraryApplication {
    private static final Logger LOG = Logger.getLogger(LibraryApplication.class);

    public static void main(String[] args) {
        try {
            LOG.debug("Initializing application");
            LibraryRepository sauLibrary = (new LibraryRepositoryFactory()).createLibraryRepository("sau");
            LibraryRepository centralLibrary = (new LibraryRepositoryFactory()).createLibraryRepository("central");
            LibraryRepository franklinLibrary = (new LibraryRepositoryFactory()).createLibraryRepository("franklin");
            List<LibraryRepository> libraryRepositories = Arrays.asList(sauLibrary, centralLibrary, franklinLibrary);
            LOG.debug("Initializing finished");

            LOG.info("Welcome to the Library Console App");
            LOG.info(String.format("App has %d libraries", libraryRepositories.size()));
            for (LibraryRepository libraryRepository: libraryRepositories){
                String libraryName = libraryRepository.getLibrary().getName();
//                LOG.info(String.format("Library: %s", libraryName));
                LOG.info((String.format("Library '%s' has %d Books available", libraryName, libraryRepository.getBookRepository().getAll().size())));
                LOG.info((String.format("Library '%s' from %d Authors", libraryName, libraryRepository.getAuthorRepository().getAll().size())));
                LOG.info((String.format("Library '%s' covering %d Genres", libraryName, libraryRepository.getGenreRepository().getAll().size())));
                Author topAuthor = libraryRepository.getAuthorRepository().getAllByBookCountDescending().get(0);
                LOG.info(String.format("Library '%s' top author: '%s'", libraryName, topAuthor));
                Genre topGenre = libraryRepository.getGenreRepository().getAllByBookCountDescending().get(0);
                LOG.info(String.format("Library '%s' top genre: '%s'", libraryName, topGenre));
            }
        } catch (Exception e) {
            LOG.error("Error encountered",  e);
            System.exit(1);
        }
    }
}
