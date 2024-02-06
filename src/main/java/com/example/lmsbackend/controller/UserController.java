package com.example.lmsbackend.controller;

import com.example.lmsbackend.controller.dto.UserDetailsDTO;
import com.example.lmsbackend.model.UserProfile;
import com.example.lmsbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/profile")
    public ResponseEntity<?> getAuthenticatedUserProfile(Authentication authentication) {
        String username = authentication.getName();
        UserProfile userProfile = userService.getUserProfileByUsername(username);
        return ResponseEntity.ok(userProfile);
    }

    @GetMapping("/admin/profile/{userId}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> getUserProfileForAdmin(@PathVariable Long userId) {
        UserProfile userProfile = userService.getUserProfileById(userId);
        return ResponseEntity.ok(userProfile);
    }

    @GetMapping("/details")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<UserDetailsDTO>> getAllUsersWithDetails() {
        List<UserDetailsDTO> userDetails = userService.findAllUsersWithDetails();
        return ResponseEntity.ok(userDetails);
    }
}
