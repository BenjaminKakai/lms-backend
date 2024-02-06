package com.example.lmsbackend.service;

import com.example.lmsbackend.controller.dto.CurrentReadDTO;
import com.example.lmsbackend.controller.dto.UserDetailsDTO;
import com.example.lmsbackend.model.CurrentRead;
import com.example.lmsbackend.model.User;
import com.example.lmsbackend.model.UserProfile;
import com.example.lmsbackend.repository.CurrentReadsRepository;
import com.example.lmsbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final CurrentReadsRepository currentReadsRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, CurrentReadsRepository currentReadsRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.currentReadsRepository = currentReadsRepository;
    }

    public User createUser(String username, String password) {
        if (userRepository.findByUsername(username).isPresent()) {
            throw new IllegalStateException("Username already taken");
        }
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(passwordEncoder.encode(password));
        return userRepository.save(newUser);
    }

    public UserProfile getUserProfileByUsername(String username) {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        List<CurrentRead> currentReads = currentReadsRepository.findByUserId(user.getId());
        return new UserProfile(user, currentReads);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public UserProfile getUserProfileById(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        List<CurrentRead> currentReads = currentReadsRepository.findByUserId(userId);
        return new UserProfile(user, currentReads);
    }

    private CurrentReadDTO convertToDTO(CurrentRead currentRead) {
        return new CurrentReadDTO(
                currentRead.getBook().getId(),
                currentRead.getBook().getName(),
                currentRead.getStartDate(),
                currentRead.getEndDate());
    }

    public List<UserDetailsDTO> findAllUsersWithDetails() {
        List<User> users = userRepository.findAll();
        return users.stream().map(user -> {
            List<CurrentRead> currentReads = currentReadsRepository.findByUserId(user.getId());
            List<CurrentReadDTO> currentReadDTOs = currentReads.stream().map(this::convertToDTO).collect(Collectors.toList());
            return new UserDetailsDTO(user.getId(), user.getUsername(), currentReadDTOs);
        }).collect(Collectors.toList());
    }
}
