package com.sourceallies.demos.library;


import com.sourceallies.demos.library.factories.BookRepositoryFactory;
import com.sourceallies.demos.library.factories.LibraryRepositoryFactory;
import com.sourceallies.demos.library.repositories.BookRepository;
import com.sourceallies.demos.library.repositories.LibraryRepository;
import org.apache.log4j.Logger;

public class LibraryApplication {
    private static final Logger LOG = Logger.getLogger(LibraryApplication.class);

    public static void main(String[] args) {
        try {
            LOG.debug("Initializing application");
            LibraryRepository sauLibrary = (new LibraryRepositoryFactory()).createLibraryRepository("sau");
            LibraryRepository centralLibrary = (new LibraryRepositoryFactory()).createLibraryRepository("central");
            LibraryRepository franklinLibrary = (new LibraryRepositoryFactory()).createLibraryRepository("franklin");
            LOG.debug("Initializing finished");

            LOG.info("Welcome to the Library Console App");

//            BookRepository sauBookRepo = sauLibrary.getBookRepository();
//            BookRepository centralBookRepo = centralLibrary.getBookRepository();
//            BookRepository franklinBookRepo = franklinLibrary.getBookRepository();
        } catch (Exception e) {
            LOG.error("Error encountered",  e);
            System.exit(1);
        }
    }
}
