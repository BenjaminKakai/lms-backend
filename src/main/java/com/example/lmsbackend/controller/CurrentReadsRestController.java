package com.example.lmsbackend.controller;

import com.example.lmsbackend.model.CurrentRead;
import com.example.lmsbackend.service.CurrentReadsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/currentReads")
public class CurrentReadsRestController {

    private final CurrentReadsService currentReadsService;

    @Autowired
    public CurrentReadsRestController(CurrentReadsService currentReadsService) {
        this.currentReadsService = currentReadsService;
    }

    // List Current Reads for a User
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<CurrentRead>> listUserCurrentReads(@PathVariable Long userId) {
        List<CurrentRead> currentReads = currentReadsService.getCurrentReadsByUserId(userId);
        return ResponseEntity.ok(currentReads);
    }

    // Assign a book to a user
    @PostMapping("/assign")
    public ResponseEntity<CurrentRead> assignBookToUser(@RequestBody AssignBookRequest request) {
        CurrentRead assignedRead = currentReadsService.assignBookToUser(
                request.getUserId(), request.getBookId(), request.getStartDate(), request.getEndDate());
        return ResponseEntity.status(HttpStatus.CREATED).body(assignedRead);
    }

    // Endpoint for returning a book
    @PostMapping("/return/{currentReadId}")
    public ResponseEntity<?> returnBook(@PathVariable Long currentReadId) {
        currentReadsService.returnBook(currentReadId);
        return ResponseEntity.ok().build();
    }

    // Define AssignBookRequest DTO here or in a separate file
    public static class AssignBookRequest {
        private Long userId;
        private Long bookId;
        private LocalDate startDate;
        private LocalDate endDate;

        // Getters and Setters
        public Long getUserId() {
            return userId;
        }

        public void setUserId(Long userId) {
            this.userId = userId;
        }

        public Long getBookId() {
            return bookId;
        }

        public void setBookId(Long bookId) {
            this.bookId = bookId;
        }

        public LocalDate getStartDate() {
            return startDate;
        }

        public void setStartDate(LocalDate startDate) {
            this.startDate = startDate;
        }

        public LocalDate getEndDate() {
            return endDate;
        }

        public void setEndDate(LocalDate endDate) {
            this.endDate = endDate;
        }
    }
}
