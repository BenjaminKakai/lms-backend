package com.example.lmsbackend.service;

import com.example.lmsbackend.model.User;
import com.example.lmsbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User createUser(String username, String rawPassword) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(rawPassword));
        return userRepository.save(user);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User updateUser(Long userId, User updatedUser) {
        return userRepository.findById(userId)
                .map(user -> {
                    user.setUsername(updatedUser.getUsername());
                    user.setPassword(passwordEncoder.encode(updatedUser.getPassword()));
                    // Update other fields as necessary
                    return userRepository.save(user);
                }).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public boolean isAdmin(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return user.getRoles().contains("ROLE_ADMIN");
    }

    public void addRoleToUser(String username, String role) {
        User user = userRepository.findByUsername(username);
        if (user != null) {
            user.getRoles().add(role);
            userRepository.save(user);
        } else {
            throw new UsernameNotFoundException("User not found");
        }
    }

    // Additional methods for user management can be added here
}
