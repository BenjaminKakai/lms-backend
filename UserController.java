package com.example.lmsbackend.controller;

import com.example.lmsbackend.model.User;
import com.example.lmsbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Method to show the registration form
    @GetMapping("/register")
    public String showRegistrationForm() {
        return "register"; // This will display the register.html when /register is accessed
    }

    // Method to handle the form submission
    @PostMapping("/register")
    public String registerUser(@RequestParam String username, @RequestParam String password) {
        User newUser = userService.createUser(username, password);
        // Implement additional logic as needed, e.g., redirect to a specific page
        return "redirect:/login"; // Redirect to login page after successful registration
    }

    // Other user-related endpoints can be added here
}
