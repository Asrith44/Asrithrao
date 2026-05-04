package com.lms;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        LibraryService service = new LibraryService();

        System.out.println("=== Library Management System ===\n");

        // Add books
        addBook(service, new Book(1, "Java Basics",        "Karthikeya", true));
        addBook(service, new Book(2, "Data Structures",    "Ramesh",     true));
        addBook(service, new Book(3, "Operating Systems",  "Suresh",     false));
        addBook(service, new Book(4, "DBMS",               "Priya",      true));

        // View all books
        viewAllBooks(service);

        // Update a book
        updateBook(service, 2, "Data Structures & Algorithms", "Ramesh", false);
        System.out.println("After Update - Book 2: " + service.getBookById(2).get());

        // Delete a book
        deleteBook(service, 4);
        System.out.println("After Delete - Total Books: " + service.getAllBooks().size());

        // Available books
        System.out.println("\nAvailable Books:");
        service.getAvailableBooks().forEach(System.out::println);
    }

    public static void addBook(LibraryService service, Book book) {
        service.addBook(book);
        System.out.println("Added: " + book);
    }

    public static void viewAllBooks(LibraryService service) {
        System.out.println("\nAll Books:");
        service.getAllBooks().forEach(System.out::println);
    }

    public static void updateBook(LibraryService service, int id,
                                   String title, String author, boolean available) {
        boolean result = service.updateBook(id, title, author, available);
        System.out.println("\nUpdate Book " + id + ": " + (result ? "Success" : "Not Found"));
    }

    public static void deleteBook(LibraryService service, int id) {
        boolean result = service.deleteBook(id);
        System.out.println("Delete Book " + id + ": " + (result ? "Success" : "Not Found"));
    }
}
