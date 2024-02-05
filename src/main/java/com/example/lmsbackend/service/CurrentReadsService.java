package com.example.lmsbackend.service;

import com.example.lmsbackend.model.Book;
import com.example.lmsbackend.model.CurrentRead;
import com.example.lmsbackend.model.User;
import com.example.lmsbackend.repository.BookRepository;
import com.example.lmsbackend.repository.CurrentReadsRepository;
import com.example.lmsbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class CurrentReadsService {

    private final CurrentReadsRepository currentReadsRepository;
    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    @Autowired
    public CurrentReadsService(CurrentReadsRepository currentReadsRepository, BookRepository bookRepository, UserRepository userRepository) {
        this.currentReadsRepository = currentReadsRepository;
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }

    public List<CurrentRead> getCurrentReadsByUserId(Long userId) {
        return currentReadsRepository.findByUserId(userId);
    }

    @Transactional
    public CurrentRead assignBookToUser(Long userId, Long bookId, LocalDate startDate, LocalDate endDate) {
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new IllegalArgumentException("Book not found"));
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found"));

        if (!book.isAvailable()) {
            throw new IllegalStateException("Book is not available for assignment");
        }

        CurrentRead currentRead = new CurrentRead();
        currentRead.setUser(user);
        currentRead.setBook(book);
        currentRead.setStartDate(startDate);
        currentRead.setEndDate(endDate);

        // Mark the book as unavailable
        book.setIsAvailable(false);
        bookRepository.save(book);

        return currentReadsRepository.save(currentRead);
    }

    @Transactional
    public void returnBook(Long currentReadId) {
        CurrentRead currentRead = currentReadsRepository.findById(currentReadId)
                .orElseThrow(() -> new IllegalArgumentException("Current Read not found"));
        Book book = currentRead.getBook();

        // Mark the book as available
        book.setIsAvailable(true);
        bookRepository.save(book);

        // Remove the CurrentRead record
        currentReadsRepository.delete(currentRead);
    }
}
