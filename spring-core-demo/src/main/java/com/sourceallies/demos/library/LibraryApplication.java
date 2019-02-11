package com.sourceallies.demos.library;


import com.sourceallies.demos.library.repositories.BookRepository;
import com.sourceallies.demos.library.repositories.LibraryRepository;

public class LibraryApplication
{
    public static void main( String[] args )
    {
        System.out.println( "Welcome to the Library Console App" );
        try {
            LibraryRepository sauLibrary = new LibraryRepository("sau");
            LibraryRepository centralLibrary = new LibraryRepository("central");
            LibraryRepository franklinLibrary = new LibraryRepository("franklin");


            BookRepository sauBookRepo = sauLibrary.getBookRepository();
            BookRepository centralBookRepo = centralLibrary.getBookRepository();
            BookRepository franklinBookRepo = franklinLibrary.getBookRepository();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
    }
}
