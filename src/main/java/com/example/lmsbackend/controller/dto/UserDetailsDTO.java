package com.example.lmsbackend.controller.dto;

import java.util.List;

public class UserDetailsDTO {
    private Long userId;
    private String username;
    private List<CurrentReadDTO> currentReads;

    public UserDetailsDTO() {}

    public UserDetailsDTO(Long userId, String username, List<CurrentReadDTO> currentReads) {
        this.userId = userId;
        this.username = username;
        this.currentReads = currentReads;
    }

    // Getters
    public Long getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public List<CurrentReadDTO> getCurrentReads() {
        return currentReads;
    }

    // Setters
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setCurrentReads(List<CurrentReadDTO> currentReads) {
        this.currentReads = currentReads;
    }
}
