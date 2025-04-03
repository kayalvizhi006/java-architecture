package com.bookstore.model;

import javax.persistence.*;

	
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // Using 'id' as the primary key

    @Column(name = "customer_name", nullable = false)
    private String customerName;

    @Column(nullable = false)
    private int quantity;

    @Column(name = "total_amount", nullable = false)
    private double totalAmount;

    @Column(name = "book_id", nullable = false)
    private int bookId;

    @Column(name = "book_title", nullable = false)
    private String bookTitle;

    // Default Constructor
    public Order() {
    }

    // Parameterized Constructor
    public Order(String customerName, int quantity, double totalAmount, int bookId, String bookTitle) {
        this.customerName = customerName;
        this.quantity = quantity;
        this.totalAmount = totalAmount; // Ensure this is set properly
        this.bookId = bookId;
        this.bookTitle = bookTitle;
    }


    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customerName='" + customerName + '\'' +
                ", quantity=" + quantity +
                ", totalAmount=" + totalAmount +
                ", bookId=" + bookId +
                ", bookTitle='" + bookTitle + '\'' +
                '}';
    }
}
