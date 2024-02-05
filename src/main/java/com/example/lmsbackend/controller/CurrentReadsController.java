package com.example.lmsbackend.controller;

import com.example.lmsbackend.service.CurrentReadsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/currentReads")
public class CurrentReadsController {

    private final CurrentReadsService currentReadsService;

    @Autowired
    public CurrentReadsController(CurrentReadsService currentReadsService) {
        this.currentReadsService = currentReadsService;
    }

    @GetMapping("/user/{userId}")
    public String listUserCurrentReads(@PathVariable Long userId, Model model) {
        // Fetch the current reads for the specified user and add them to the model
        model.addAttribute("currentReads", currentReadsService.getCurrentReadsByUserId(userId));
        // Return the Thymeleaf template for displaying user's current reads
        return "userCurrentReads";
    }

    // Removed the addCurrentRead method to align with RESTful approach
    // Other methods for managing current reads through the web interface can be added here if necessary
}
