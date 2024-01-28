package com.example.lmsbackend;

import com.example.lmsbackend.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    // Here you can define custom query methods if needed, e.g.:
    // List<Book> findByAuthor(String author);
}