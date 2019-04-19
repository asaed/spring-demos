package com.sourceallies.demos.library.controllers;

import com.sourceallies.demos.library.domain.Book;
import com.sourceallies.demos.library.repositories.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/libraries/{libraryId}/books")
public class BookController {

    @Autowired
    private List<LibraryService> libraryServices;

    @GetMapping
    public List<Book> getBooks(@PathVariable String libraryId){
        LibraryService service = getLibraryService(libraryId);

        return service.getBookRepository().getAll();
    }






    @GetMapping("/search")
    public List<Book> searchBooks(@PathVariable String libraryId,
                                  @RequestParam(required = false) String authorName,
                                  @RequestParam(required = false) String bookTitle,
                                  @RequestParam(required = false) List<String> genres) {
        LibraryService service = getLibraryService(libraryId);

        return service.getBookRepository().getAll().stream()
                .filter(currentBook -> currentBook.getAuthors().stream().anyMatch(currentAuthorName ->
                        authorName == null || currentAuthorName.toLowerCase().contains(authorName.toLowerCase())))
                .filter(currentBook ->
                        bookTitle == null || currentBook.getTitle().toLowerCase().contains(bookTitle.toLowerCase()))
                .filter(currentBook -> currentBook.getGenres().stream().anyMatch(currentGenre ->
                                genres == null || genres.isEmpty() || genres.stream().anyMatch(genre -> currentGenre.toLowerCase().contains(genre.toLowerCase()))))
                .collect(Collectors.toList());
    }



    
    private LibraryService getLibraryService(@PathVariable String libraryId) {
        return libraryServices.stream()
                .filter(libraryService -> libraryService.getLibrary().getId().equalsIgnoreCase(libraryId))
                .findFirst()
                .get();
    }
}
