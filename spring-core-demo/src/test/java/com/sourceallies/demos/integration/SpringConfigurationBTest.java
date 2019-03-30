package com.sourceallies.demos.integration;

import com.sourceallies.demos.library.domain.Book;
import com.sourceallies.demos.library.domain.Library;
import com.sourceallies.demos.library.repositories.AuthorRepository;
import com.sourceallies.demos.library.repositories.BookRepository;
import com.sourceallies.demos.library.repositories.LibraryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/com/sourceallies/demos/library/applicationContext.xml"})
public class SpringConfigurationBTest {

    @Autowired
    private ApplicationContext context;
    @Autowired
    private Library sauLibrary;
    @Autowired
    private List<Book> sauBooks;
    @Autowired
    private BookRepository sauBookRepository;
    @Autowired
    private AuthorRepository sauAuthorRepository;
    @Autowired
    private LibraryService sauLibraryService;

    @Test
    public void sau_shouldHaveSauLibrary() {
        assertNotNull(sauLibrary);
    }

    @Test
    public void sau_shouldHaveSauBooks() {
        assertFalse(sauBooks.isEmpty());
    }

    @Test
    public void sau_shouldHaveSauBookRepository() {
        assertNotNull(sauBookRepository);
    }

    @Test
    public void sau_shouldHaveSauAuthorRepository() {
        assertNotNull(sauAuthorRepository);
    }

    @Test
    public void sau_shouldHaveSauLibraryService() {
        assertNotNull(sauLibraryService);
    }
}
