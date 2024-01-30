package com.example.lmsbackend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home(Model model) {
        // You can add attributes to the model here if needed
        return "home"; // This should match the name of the home view template: home.html
    }
}