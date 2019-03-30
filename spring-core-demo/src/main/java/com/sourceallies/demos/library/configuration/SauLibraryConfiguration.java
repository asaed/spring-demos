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
public class SauLibraryConfiguration {

    @Autowired
    private LibraryDataLoader libraryDataLoader;

    @Bean
    public Library sauLibrary() {
        return libraryDataLoader.loadLibrary("sau");
    }

    @Bean
    public List<Book> sauBooks() {
        return libraryDataLoader.loadBooks("sau");
    }

    @Bean
    public SimpleBookRepository sauBookRepository() {
        return new SimpleBookRepository(sauBooks());
    }

    @Bean
    public SimpleAuthorRepository sauAuthorRepository() {
        return new SimpleAuthorRepository(sauBookRepository());
    }

    @Bean
    public SimpleLibraryService sauLibraryService() {
        return new SimpleLibraryService(sauLibrary(), sauBookRepository(), sauAuthorRepository());
    }

}
