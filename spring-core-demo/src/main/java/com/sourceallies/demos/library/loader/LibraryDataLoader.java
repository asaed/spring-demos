package com.sourceallies.demos.library.loader;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sourceallies.demos.library.domain.Book;
import com.sourceallies.demos.library.domain.Library;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.List;

public class LibraryDataLoader {
    private static final Logger LOG = Logger.getLogger(LibraryDataLoader.class);

    public static List<Book> loadBooks(String libraryBasePath) {
        InputStream is =
                IOUtils.class.getResourceAsStream("/com/sourceallies/demos/library/" + libraryBasePath + "/books.json");
        try {
            String jsonTxt = IOUtils.toString(is, Charset.defaultCharset());
            ObjectMapper objectMapper = new ObjectMapper();
            List<Book> books = objectMapper.readValue(jsonTxt, new TypeReference<List<Book>>() {
            });
            LOG.debug(String.format("Loaded %d books for %s library", books.size(), libraryBasePath));
            return books;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            IOUtils.closeQuietly(is);
        }
    }

    public static Library loadLibrary(String libraryBasePath) {
        InputStream is =
                IOUtils.class.getResourceAsStream("/com/sourceallies/demos/library/" + libraryBasePath + "/library.json");
        try {
            String jsonTxt = IOUtils.toString(is, Charset.defaultCharset());
            ObjectMapper objectMapper = new ObjectMapper();
            Library library = objectMapper.readValue(jsonTxt, Library.class);
            LOG.debug(String.format("Loaded %s library metadata", libraryBasePath));
            return library;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            IOUtils.closeQuietly(is);
        }
    }
}
