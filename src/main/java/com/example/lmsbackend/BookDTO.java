package com.example.lmsbackend;

public class BookDTO {
    private Long id; // Assuming you want to include the id for updates
    private String name;
    private String isbn;
    private String author;
    private Boolean isAvailable; // Optional: Include availability flag

    // Constructors
    public BookDTO() {
    }

    public BookDTO(Long id, String name, String isbn, String author, Boolean isAvailable) {
        this.id = id;
        this.name = name;
        this.isbn = isbn;
        this.author = author;
        this.isAvailable = isAvailable; // Initialize with availability if provided
    }

    // Getters and setters for all fields
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(Boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    // Optional: Override toString, equals, and hashCode methods for better logging and functionality
}
