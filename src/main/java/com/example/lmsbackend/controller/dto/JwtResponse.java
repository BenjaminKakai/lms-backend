package com.example.lmsbackend.controller.dto;

public class JwtResponse {
    private final String token;
    private final String type = "Bearer";

    public JwtResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public String getType() {
        return type;
    }
}
