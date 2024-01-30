package com.example.lmsbackend.repository;

import com.example.lmsbackend.model.CurrentRead;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CurrentReadsRepository extends JpaRepository<CurrentRead, Long> {
    List<CurrentRead> findByUserId(Long userId);
}
