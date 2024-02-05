package com.example.lmsbackend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String isbn;
    private String name;
    private String author;
    private boolean isAvailable; // Field to track availability

    // Constructors
    public Book() {
        this.isAvailable = true; // Books are available by default
    }

    public Book(Long id, String name, String isbn, String author) {
        this.id = id;
        this.name = name;
        this.isbn = isbn;
        this.author = author;
        this.isAvailable = true; // Initialize the book as available by default
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    // toString method as you've defined
    @Override
    public String toString() {
        // Your existing toString implementation
        return "Book{" +
                "id=" + id +
                ", isbn='" + isbn + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", isAvailable=" + isAvailable +
                '}';
    }

    // Consider implementing equals and hashCode methods
}
