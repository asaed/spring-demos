package com.sourceallies.demos.integration;

import com.sourceallies.demos.library.configuration.LibraryApplicationConfiguration;
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
@ContextConfiguration(classes = {LibraryApplicationConfiguration.class})
public class SpringConfigurationATest {

    @Autowired
    private ApplicationContext context;

    @Test
    public void sau_shouldHaveSauLibrary(){
        Library sauLibrary = context.getBean("sauLibrary", Library.class);

        assertNotNull(sauLibrary);
    }

    @Test
    public void sau_shouldHaveSauBooks(){
        List<Book> sauBooks = context.getBean("sauBooks", List.class);

        assertFalse(sauBooks.isEmpty());
    }

    @Test
    public void sau_shouldHaveSauBookRepository(){
        BookRepository sauBookRepository = context.getBean("sauBookRepository", BookRepository.class);

        assertNotNull(sauBookRepository);
    }

    @Test
    public void sau_shouldHaveSauAuthorRepository(){
        AuthorRepository sauAuthorRepository = context.getBean("sauAuthorRepository", AuthorRepository.class);

        assertNotNull(sauAuthorRepository);
    }

    @Test
    public void sau_shouldHaveSauLibraryService(){
        LibraryService sauLibraryService = context.getBean("sauLibraryService", LibraryService.class);

        assertNotNull(sauLibraryService);
    }
}