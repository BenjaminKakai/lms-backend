package com.example.lmsbackend.service;

import com.example.lmsbackend.model.CurrentRead;
import com.example.lmsbackend.repository.CurrentReadsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurrentReadsService {

    private final CurrentReadsRepository currentReadsRepository;

    @Autowired
    public CurrentReadsService(CurrentReadsRepository currentReadsRepository) {
        this.currentReadsRepository = currentReadsRepository;
    }

    public List<CurrentRead> getCurrentReadsByUserId(Long userId) {
        return currentReadsRepository.findByUserId(userId);
    }

    public CurrentRead addCurrentRead(CurrentRead currentRead) {
        return currentReadsRepository.save(currentRead);
    }

    public CurrentRead updateCurrentRead(Long id, CurrentRead updatedCurrentRead) {
        return currentReadsRepository.findById(id)
                .map(currentRead -> {
                    currentRead.setBook(updatedCurrentRead.getBook());
                    currentRead.setStartDate(updatedCurrentRead.getStartDate());
                    currentRead.setEndDate(updatedCurrentRead.getEndDate());
                    // Other fields to be updated
                    return currentReadsRepository.save(currentRead);
                }).orElseThrow(() -> new RuntimeException("Current Read not found!"));
    }

    public void deleteCurrentRead(Long id) {
        currentReadsRepository.deleteById(id);
    }

    // Additional methods for managing current reads can be added here
}
