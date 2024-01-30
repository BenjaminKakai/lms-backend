package com.example.lmsbackend.controller;

import com.example.lmsbackend.model.User;
import com.example.lmsbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Method to show the registration form
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    // Method to handle the form submission
    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user) {
        userService.createUser(user.getUsername(), user.getPassword());
        // Implement additional logic as needed, e.g., redirect to a specific page
        return "redirect:/login"; // Redirect to login page after successful registration
    }

    // Other user-related endpoints can be added here
}
