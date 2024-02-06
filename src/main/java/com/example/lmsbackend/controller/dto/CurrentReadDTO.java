package com.example.lmsbackend.controller.dto;

import java.time.LocalDate;

public class CurrentReadDTO {
    private Long bookId;
    private String bookName;
    private LocalDate startDate;
    private LocalDate endDate;

    public CurrentReadDTO() {}

    public CurrentReadDTO(Long bookId, String bookName, LocalDate startDate, LocalDate endDate) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    // Getters
    public Long getBookId() {
        return bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    // Setters
    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
