package com.example.lmsbackend.service;

import com.example.lmsbackend.controller.dto.LoginRequest;
import org.springframework.http.ResponseEntity;

public interface AuthService {
    ResponseEntity<?> authenticateUser(LoginRequest loginRequest);
}
