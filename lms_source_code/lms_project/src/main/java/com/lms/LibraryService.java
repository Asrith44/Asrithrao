package com.lms;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class LibraryService {

    private List<Book> books = new ArrayList<>();

    /** Add a book to the library. */
    public void addBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Book cannot be null");
        }
        if (book.getTitle() == null || book.getTitle().trim().isEmpty()) {
            throw new IllegalArgumentException("Book title cannot be empty");
        }
        books.add(book);
    }

    /** Retrieve all books. */
    public List<Book> getAllBooks() {
        return new ArrayList<>(books);
    }

    /** Find a book by its ID. */
    public Optional<Book> getBookById(int id) {
        return books.stream()
                    .filter(b -> b.getId() == id)
                    .findFirst();
    }

    /** Update a book's details. Returns true if found and updated. */
    public boolean updateBook(int id, String title, String author, boolean available) {
        Optional<Book> opt = getBookById(id);
        if (opt.isPresent()) {
            Book b = opt.get();
            b.setTitle(title);
            b.setAuthor(author);
            b.setAvailable(available);
            return true;
        }
        return false;
    }

    /** Delete a book by ID. Returns true if found and deleted. */
    public boolean deleteBook(int id) {
        return books.removeIf(b -> b.getId() == id);
    }

    /** Return only available books. */
    public List<Book> getAvailableBooks() {
        return books.stream()
                    .filter(Book::isAvailable)
                    .collect(Collectors.toList());
    }
}
