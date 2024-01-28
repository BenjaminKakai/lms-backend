package com.example.lmsbackend;

public class BookDTO {
    private Long id; // Assuming you want to include the id for updates
    private String name;
    private String isbn;
    private String author;

    // Constructors
    public BookDTO() {
    }

    public BookDTO(Long id, String name, String isbn, String author) {
        this.id = id;
        this.name = name;
        this.isbn = isbn;
        this.author = author;
    }

    // Getters and setters
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

    // toString, equals, and hashCode methods can be added for better logging and functionality
}