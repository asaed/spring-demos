package com.sourceallies.demos.library.loader;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sourceallies.demos.library.domain.Book;
import com.sourceallies.demos.library.domain.Library;
import org.apache.commons.io.IOUtils;

import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.List;

public class LibraryDataLoader {
    public List<Book> loadBooks(String libraryBasePath) {
        InputStream is =
                IOUtils.class.getResourceAsStream("/com/sourceallies/demos/library/" + libraryBasePath + "/books.json");
        try {
            String jsonTxt = IOUtils.toString(is, Charset.defaultCharset());
            ObjectMapper objectMapper = new ObjectMapper();
            List<Book> books = objectMapper.readValue(jsonTxt, new TypeReference<List<Book>>() {
            });
            System.out.println(libraryBasePath + ": " + books);
            return books;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            IOUtils.closeQuietly(is);
        }
    }

    public Library loadLibrary(String libraryBasePath) {
        InputStream is =
                IOUtils.class.getResourceAsStream("/com/sourceallies/demos/library/" + libraryBasePath + "/library.json");
        try {
            String jsonTxt = IOUtils.toString(is, Charset.defaultCharset());
            ObjectMapper objectMapper = new ObjectMapper();
            Library library = objectMapper.readValue(jsonTxt, Library.class);
            System.out.println(libraryBasePath + ": " + library);
            return library;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            IOUtils.closeQuietly(is);
        }
    }
}
