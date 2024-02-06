package com.example.lmsbackend.model;

import java.util.List;

public class UserProfile {
    private User user;
    private List<CurrentRead> currentReads;

    public UserProfile(User user, List<CurrentRead> currentReads) {
        this.user = user;
        this.currentReads = currentReads;
    }

    // Getters and setters
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<CurrentRead> getCurrentReads() {
        return currentReads;
    }

    public void setCurrentReads(List<CurrentRead> currentReads) {
        this.currentReads = currentReads;
    }
}
