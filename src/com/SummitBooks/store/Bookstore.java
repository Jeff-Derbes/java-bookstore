package com.SummitBooks.store;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Bookstore {
    private List<Book> books = new ArrayList<>();

    // Adds a book to the bookstore
    public void addBook(Book book) {
        books.add(book);
    }

    // Prints all books in the bookstore
    public void printInventory() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void sortBooksByTitle() {
        Collections.sort(books);
    }

    public void saveInventoryToFile(String filename) {
        File file = new File(filename);
        try {
            if (!file.exists()) {
                file.createNewFile(); // Create the file if it doesn't exist
            }
            try (PrintWriter out = new PrintWriter(new FileWriter(file, false))) {
                for (Book book : books) {
                    out.println(STR."\{book.getIsbn()},\{book.getTitle()},\{book.getAuthor()}");
                }
            }
        } catch (IOException e) {
            System.err.println(STR."Error saving inventory: \{e.getMessage()}");
        }
    }

    public void loadInventoryFromFile(String filename) {
        File file = new File(filename);
        try {
            if (!file.exists()) {
                file.createNewFile(); // Create the file if it doesn't exist
                return; // If the file was just created, there's nothing to load
            }
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(",");
                    if (parts.length >= 3) {
                        addBook(new Book(parts[0], parts[1], parts[2]));
                    }
                }
            }
        } catch (IOException e) {
            System.err.println(STR."Error loading inventory: \{e.getMessage()}");
        }
    }

// Give me the searchBooks method above but change it to allow users to select search by author or title
    public void searchBooks(String query, String searchBy) {
        boolean found = false;
        for (Book book : books) {
            if (searchBy.equals("title") && book.getTitle().toLowerCase().contains(query.toLowerCase())) {
                System.out.println(book);
                found = true;
            } else if (searchBy.equals("author") && book.getAuthor().toLowerCase().contains(query.toLowerCase())) {
                System.out.println(book);
                found = true;
            }
        }
        if (!found) {
            System.out.println(STR."No books found matching: \{query}");
        }
    }

    public void editBookDetails(String isbn, String newTitle, String newAuthor) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                if (!newTitle.isEmpty()) {
                    book.setTitle(newTitle);
                }
                if (!newAuthor.isEmpty()) {
                    book.setAuthor(newAuthor);
                }
            }
        }
    }

    public void removeBooksByIsbn(String isbn) {
        books.removeIf(book -> book.getIsbn().equals(isbn));
    }
}

