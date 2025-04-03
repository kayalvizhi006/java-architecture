package com.bookstore.util;

import com.bookstore.dao.OrderDAO;
import com.bookstore.dao.BookDAO;
import com.bookstore.model.Book;
import com.bookstore.model.Order;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BookDAO bookDAO = new BookDAO();
        OrderDAO orderDAO = new OrderDAO();

        // Display available books
        System.out.println("\n📚 Available Books:");
        List<Book> books = bookDAO.getAllBooks();
        for (Book book : books) {
            System.out.println("ID: " + book.getId() + " | Title: " + book.getTitle() +
                    " | Author: " + book.getAuthor() + " | Price: $" + book.getPrice());
        }

        // Select multiple books
        List<Book> selectedBooks = new ArrayList<>();
        double totalAmount = 0;
        
        while (true) {
            System.out.print("\nEnter Book ID to select (0 to finish): ");
            int bookId = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            if (bookId == 0) break; // Stop selection

            Book selectedBook = bookDAO.getBookById(bookId);
            if (selectedBook == null) {
                System.out.println("❌ Invalid Book ID. Try again.");
            } else {
                selectedBooks.add(selectedBook);
                totalAmount += selectedBook.getPrice();
                System.out.println("✅ Added: " + selectedBook.getTitle() + " ($" + selectedBook.getPrice() + ")");
            }
        }

        // Check if any books were selected
        if (selectedBooks.isEmpty()) {
            System.out.println("⚠️ No books selected. Exiting...");
            return;
        }

        // Display selected books and total amount
        System.out.println("\n📌 You selected:");
        for (Book book : selectedBooks) {
            System.out.println("- " + book.getTitle() + " | $" + book.getPrice());
        }
        System.out.println("💰 Total Amount: $" + totalAmount);

        // Enter customer name
        System.out.print("\nEnter Customer Name: ");
        String customerName = scanner.nextLine();

        // Order options
        System.out.println("\n1. Buy Now");
        System.out.println("2. Add to Cart");
        System.out.println("3. Exit");
        System.out.print("\nChoose an option: ");
        int choice = scanner.nextInt();

        if (choice == 1) {  // Buy Now
            for (Book book : selectedBooks) {
                Order newOrder = new Order(customerName, 1, book.getPrice(), book.getId(), book.getTitle());
                orderDAO.saveOrder(newOrder);
            }
            System.out.println("\n✅ Order placed successfully for " + customerName + "!");
            System.out.println("💰 Final Total Amount: $" + totalAmount);

        } else if (choice == 2) {  // Add to Cart
            System.out.println("\n🛒 Books added to cart.");
        } else {
            System.out.println("\nExiting...");
        }

        scanner.close();
    }
}
