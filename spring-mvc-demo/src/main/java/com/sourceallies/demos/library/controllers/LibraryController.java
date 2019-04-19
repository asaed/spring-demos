package com.sourceallies.demos.library.controllers;

import com.sourceallies.demos.library.domain.Library;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/libraries")
public class LibraryController {

    @Autowired
    private List<Library> libraries;

    @GetMapping
    public List<Library> getLibraries(){
        return libraries;
    }










    @GetMapping("/{libraryId}")
    public ResponseEntity getLibrary(@PathVariable String libraryId){
        Optional<Library> foundLibrary = libraries.stream()
                .filter(library -> library.getId().equalsIgnoreCase(libraryId))
                .findFirst();

        if (foundLibrary.isPresent()) {
            return ResponseEntity.ok(foundLibrary.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
