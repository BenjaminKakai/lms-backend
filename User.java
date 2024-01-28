package com.example.lmsbackend.model;

import jakarta.persistence.*;


@Entity
@Table(name = "users") // Use "app_users" or another non-reserved name if using PostgreSQL
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    // Additional fields like roles, enabled status, etc. can be added here

    // Constructors
    public User() {
        // Default constructor
    }

    // Assuming you might want a constructor to create a user with credentials
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Standard getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // You can add additional getters and setters for other fields as needed

    // toString, equals, and hashCode methods can be added for better logging and functionality
}