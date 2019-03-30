package com.sourceallies.demos.integration.aggregation;

import com.sourceallies.demos.library.domain.Book;
import com.sourceallies.demos.library.domain.Library;
import com.sourceallies.demos.library.repositories.AuthorRepository;
import com.sourceallies.demos.library.repositories.BookRepository;
import com.sourceallies.demos.library.repositories.LibraryService;
import com.sourceallies.demos.library.repositories.aggregation.AggregatingBookRepository;
import com.sourceallies.demos.library.repositories.simple.SimpleBookRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/com/sourceallies/demos/library/applicationContext.xml"})
public class AggregatingBookRepositoryTest {

    @Autowired
    private AggregatingBookRepository aggregatingBookRepository;
    @Autowired
    private SimpleBookRepository sauBookRepository;
    @Autowired
    private SimpleBookRepository centralBookRepository;

    @Test
    public void shouldHaveCorrectNumberOfBooks() {
        assertEquals(17, aggregatingBookRepository.getAll().size());
    }

    @Test
    public void shouldHaveBooksFromSauLibrary() {
        assertTrue(sauBookRepository.getAll().size() <= aggregatingBookRepository.getAll().size());
        for (Book sauBook : sauBookRepository.getAll()) {
            assertTrue(aggregatingBookRepository.getAll().contains(sauBook));
        }
    }

    @Test
    public void shouldHaveBooksFromCentralLibrary() {
        assertTrue(centralBookRepository.getAll().size() <= aggregatingBookRepository.getAll().size());
        for (Book sauBook : centralBookRepository.getAll()) {
            assertTrue(aggregatingBookRepository.getAll().contains(sauBook));
        }
    }

}
