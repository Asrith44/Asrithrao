package com.lms;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;
import java.util.Optional;

public class LibraryServiceTest {

    private LibraryService service;

    @Before
    public void setup() {
        service = new LibraryService();
        service.addBook(new Book(1, "Java Basics",       "Karthikeya", true));
        service.addBook(new Book(2, "Data Structures",   "Ramesh",     true));
        service.addBook(new Book(3, "Operating Systems", "Suresh",     false));
    }

    // TC-01
    @Test
    public void testAddBook() {
        service.addBook(new Book(4, "DBMS", "Priya", true));
        assertEquals(4, service.getAllBooks().size());
    }

    // TC-02
    @Test
    public void testGetBookById_Found() {
        Optional<Book> opt = service.getBookById(1);
        assertTrue(opt.isPresent());
        assertEquals("Java Basics", opt.get().getTitle());
    }

    // TC-03
    @Test
    public void testGetBookById_NotFound() {
        Optional<Book> opt = service.getBookById(99);
        assertFalse(opt.isPresent());
    }

    // TC-04
    @Test
    public void testGetAllBooks() {
        assertEquals(3, service.getAllBooks().size());
    }

    // TC-05
    @Test
    public void testUpdateBook_Success() {
        boolean result = service.updateBook(2, "DS & Algorithms", "Ramesh", false);
        assertTrue(result);
        assertFalse(service.getBookById(2).get().isAvailable());
    }

    // TC-06
    @Test
    public void testUpdateBook_NotFound() {
        boolean result = service.updateBook(99, "Unknown", "Unknown", true);
        assertFalse(result);
    }

    // TC-07
    @Test
    public void testDeleteBook_Success() {
        boolean result = service.deleteBook(3);
        assertTrue(result);
        assertEquals(2, service.getAllBooks().size());
    }

    // TC-08
    @Test
    public void testDeleteBook_NotFound() {
        boolean result = service.deleteBook(99);
        assertFalse(result);
    }

    // TC-09
    @Test
    public void testGetAvailableBooks() {
        List<Book> available = service.getAvailableBooks();
        assertEquals(2, available.size());
    }

    // TC-10
    @Test
    public void testGetAvailableBooks_Empty() {
        LibraryService emptyService = new LibraryService();
        assertEquals(0, emptyService.getAvailableBooks().size());
    }

    // TC-11
    @Test(expected = IllegalArgumentException.class)
    public void testAddNullBook() {
        service.addBook(null);
    }
}
