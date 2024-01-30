package com.example.lmsbackend.controller;

import com.example.lmsbackend.model.CurrentRead;
import com.example.lmsbackend.service.CurrentReadsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        model.addAttribute("currentReads", currentReadsService.getCurrentReadsByUserId(userId));
        return "userCurrentReads"; // Thymeleaf template for displaying user's current reads
    }

    @PostMapping
    public String addCurrentRead(@ModelAttribute CurrentRead currentRead) {
        currentReadsService.addCurrentRead(currentRead);
        // Assuming the User object is correctly set in the CurrentRead object
        return "redirect:/currentReads/user/" + currentRead.getUser().getId();
    }

    // Other methods for managing current reads...
}
