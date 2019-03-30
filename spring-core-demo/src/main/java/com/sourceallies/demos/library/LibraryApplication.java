package com.sourceallies.demos.library;

import com.sourceallies.demos.library.configuration.CentralLibraryConfiguration;
import com.sourceallies.demos.library.configuration.LibraryApplicationConfiguration;
import com.sourceallies.demos.library.configuration.SauLibraryConfiguration;
import com.sourceallies.demos.library.domain.Author;
import com.sourceallies.demos.library.repositories.LibraryService;
import com.sourceallies.demos.library.repositories.aggregation.AggregatingAuthorRepository;
import com.sourceallies.demos.library.repositories.aggregation.AggregatingBookRepository;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class LibraryApplication {
    private static final Logger LOG = Logger.getLogger(LibraryApplication.class);

    public static void main(String[] args) {
        try {
            LOG.debug("=========================");
            LOG.debug("Initializing application");

//            ApplicationContext context = new ClassPathXmlApplicationContext("/com/sourceallies/demos/library/applicationContext.xml");
            AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                    LibraryApplicationConfiguration.class
            );

            ArrayList<LibraryService> libraryRepositories = new ArrayList<>(context.getBeansOfType(LibraryService.class).values());

            AggregatingBookRepository aggregatingBookRepository = context.getBean("aggregatingBookRepository", AggregatingBookRepository.class);
            AggregatingAuthorRepository aggregatingAuthorRepository = context.getBean("aggregatingAuthorRepository", AggregatingAuthorRepository.class);

            LOG.debug("Initializing finished");

            LOG.info("Welcome to the Library Console App");
            LOG.info("=========================");
            printStatisticsForEachLibrary(libraryRepositories);

            LOG.info("=========================");
            printAggregatedStatisticsFromAllLibraries(aggregatingBookRepository, aggregatingAuthorRepository);
        } catch (Exception e) {
            LOG.error("Error encountered", e);
            System.exit(1);
        }
    }

    private static void printAggregatedStatisticsFromAllLibraries(AggregatingBookRepository aggregatingBookRepository, AggregatingAuthorRepository aggregatingAuthorRepository) {
        LOG.info("Aggregated info");
        LOG.info((String.format("On aggregate we have %d Books available", aggregatingBookRepository.getAll().size())));
        LOG.info((String.format("On aggregate from %d Authors", aggregatingAuthorRepository.getAll().size())));
        Author topAggregateAuthor = aggregatingAuthorRepository.getAllByBookCountDescending().get(0);
        LOG.info(String.format("On aggregate top author: '%s'", topAggregateAuthor));
    }

    private static void printStatisticsForEachLibrary(List<LibraryService> libraryRepositories) {
        LOG.info(String.format("App has %d libraries", libraryRepositories.size()));
        for (LibraryService libraryService : libraryRepositories) {
            String libraryName = libraryService.getLibrary().getName();
            LOG.info((String.format("Library '%s' has %d Books available", libraryName, libraryService.getBookRepository().getAll().size())));
            LOG.info((String.format("Library '%s' from %d Authors", libraryName, libraryService.getAuthorRepository().getAll().size())));
            Author topAuthor = libraryService.getAuthorRepository().getAllByBookCountDescending().get(0);
            LOG.info(String.format("Library '%s' top author: '%s'", libraryName, topAuthor));
        }
    }
}
