package com.example.lmsbackend.controller;

import com.example.lmsbackend.controller.dto.LoginRequest; // Ensure this DTO is correctly created
import com.example.lmsbackend.model.User;
import com.example.lmsbackend.service.AuthService; // The AuthService interface
import com.example.lmsbackend.service.UserService; // The UserService for handling user-related operations
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;
    private final AuthService authService; // Service for handling authentication logic

    @Autowired
    public AuthController(UserService userService, AuthService authService) {
        this.userService = userService;
        this.authService = authService;
    }

    // Endpoint for user registration
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        // Assuming createUser hashes the password and saves the user
        userService.createUser(user.getUsername(), user.getPassword());
        // You might want to adjust the response as per your application's needs
        return ResponseEntity.ok("User registered successfully.");
    }

    // Endpoint for user login
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest) {
        // Correct method call to authenticateUser
        return authService.authenticateUser(loginRequest);
    }

    // Additional endpoints for authentication can be added here
}
