package com.sourceallies.demos.library.controllers;

import com.sourceallies.demos.library.domain.Book;
import com.sourceallies.demos.library.repositories.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/libraries/{libraryId}/books")
public class BookController {

    @Autowired
    private List<LibraryService> libraryServices;

    @GetMapping
    public ResponseEntity getBooks(@PathVariable String libraryId){
        Optional<LibraryService> maybeService = getLibraryService(libraryId);

        if (maybeService.isPresent()) {
            List<Book> books = maybeService.get().getBookRepository().getAll();
            return ResponseEntity.ok(books);
        } else {
            return ResponseEntity.badRequest().body("Incorrect libraryId");
        }
    }






    @GetMapping("/search")
    public ResponseEntity searchBooks(@PathVariable String libraryId,
                                  @RequestParam(required = false) String authorName,
                                  @RequestParam(required = false) String bookTitle,
                                  @RequestParam(required = false) List<String> genres) {
        Optional<LibraryService> maybeService = getLibraryService(libraryId);

        if (maybeService.isPresent()) {

            List<Book> books = maybeService.get().getBookRepository().getAll().stream()
                    .filter(currentBook -> currentBook.getAuthors().stream().anyMatch(currentAuthorName ->
                            authorName == null || currentAuthorName.toLowerCase().contains(authorName.toLowerCase())))
                    .filter(currentBook ->
                            bookTitle == null || currentBook.getTitle().toLowerCase().contains(bookTitle.toLowerCase()))
                    .filter(currentBook -> currentBook.getGenres().stream().anyMatch(currentGenre ->
                            genres == null || genres.isEmpty() || genres.stream().anyMatch(genre -> currentGenre.toLowerCase().contains(genre.toLowerCase()))))
                    .collect(Collectors.toList());
            return ResponseEntity
                    .ok()
                    .header("X-NUMBER-OF-BOOKS", String.valueOf(books.size()))
                    .body(books);
        } else {
            return ResponseEntity.badRequest().body("Incorrect libraryId");

        }
    }




    private Optional<LibraryService> getLibraryService(@PathVariable String libraryId) {
        return libraryServices.stream()
                .filter(libraryService -> libraryService.getLibrary().getId().equalsIgnoreCase(libraryId))
                .findFirst();
    }
}
