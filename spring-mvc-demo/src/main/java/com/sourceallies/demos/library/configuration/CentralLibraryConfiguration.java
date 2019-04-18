package com.sourceallies.demos.library.configuration;

import com.sourceallies.demos.library.domain.Book;
import com.sourceallies.demos.library.domain.Library;
import com.sourceallies.demos.library.loader.LibraryDataLoader;
import com.sourceallies.demos.library.repositories.simple.SimpleAuthorRepository;
import com.sourceallies.demos.library.repositories.simple.SimpleBookRepository;
import com.sourceallies.demos.library.repositories.simple.SimpleLibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CentralLibraryConfiguration {

    @Autowired
    private LibraryDataLoader libraryDataLoader;

    @Bean
    public Library centralLibrary() {
        return libraryDataLoader.loadLibrary("central");
    }

    @Bean
    public List<Book> centralBooks() {
        return libraryDataLoader.loadBooks("central");
    }

    @Bean
    public SimpleBookRepository centralBookRepository() {
        return new SimpleBookRepository(centralBooks());
    }

    @Bean
    public SimpleAuthorRepository centralAuthorRepository() {
        return new SimpleAuthorRepository(centralBookRepository());
    }

    @Bean
    public SimpleLibraryService centralLibraryService() {
        return new SimpleLibraryService(centralLibrary(), centralBookRepository(), centralAuthorRepository());
    }

}
