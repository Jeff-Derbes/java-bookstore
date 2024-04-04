package com.SummitBooks.store;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Bookstore myBookstore = new Bookstore();

        // File name for storing inventory
        String inventoryFile = "bookstore_inventory.txt";
        myBookstore.loadInventoryFromFile(inventoryFile);

        myBookstore.sortBooksByTitle();
        System.out.println("Welcome to your Summit Books app!");

        while (true){
            System.out.println("\nMenu");
            System.out.println("1. Add a book");
            System.out.println("2. Remove books");
            System.out.println("3. Edit books");
            System.out.println("4. Search for books");
            System.out.println("5. Print Inventory");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter an ISBN for the book ");
                    String isbn = scanner.nextLine();
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author name: ");
                    String author = scanner.nextLine();
                    myBookstore.addBook(new Book(isbn, title, author));
                    System.out.println(STR."\{title} by \{author} added successfully!");
                    break;
                case 2:
                    System.out.print("Enter ISBN of the book to remove: ");
                    String isbnToRemove = scanner.nextLine();
                    myBookstore.removeBooksByIsbn(isbnToRemove);
                    System.out.println("If book was in the inventory, it has been removed!");
                    break;
                case 3:
                    System.out.print("Enter the ISBN of the book to edit: ");
                    String isbnToEdit = scanner.nextLine();
                    System.out.print("Enter the new title: ");
                    String newTitle = scanner.nextLine();
                    System.out.print("Enter the new author: ");
                    String newAuthor = scanner.nextLine();
                    myBookstore.editBookDetails(isbnToEdit, newTitle, newAuthor);
                    System.out.println("Book edited successfully!");
                    break;
                case 4:
                    System.out.print("Would you like to search by title or author? ");
                    String searchBy = scanner.nextLine();
                    System.out.print("Enter search query: ");
                    String query = scanner.nextLine();
                    myBookstore.searchBooks(query, searchBy);
                    break;
                case 5:
                    System.out.println("Books available in the bookstore: ");
                    myBookstore.printInventory();
                    break;
                case 6:
                    myBookstore.saveInventoryToFile(inventoryFile);
                    System.out.println("thank you for using our Bookstore! ");
                    return;
                default:
                    System.out.println("Invalid choice, please try again");
            }
        }

    }
}
