package com.example.lmsbackend.service;

import com.example.lmsbackend.model.Book;
import com.example.lmsbackend.BookDTO;
import com.example.lmsbackend.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Transactional(readOnly = true)
    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Book> findBookById(Long id) {
        return bookRepository.findById(id);
    }

    @Transactional
    public Book createBook(BookDTO bookDTO) {
        Book book = new Book();
        updateBookEntityFromDTO(book, bookDTO);
        return bookRepository.save(book);
    }

    @Transactional
    public Optional<Book> updateBook(Long id, BookDTO bookDTO) {
        return bookRepository.findById(id)
                .map(book -> {
                    updateBookEntityFromDTO(book, bookDTO);
                    return bookRepository.save(book);
                });
    }

    @Transactional
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    private void updateBookEntityFromDTO(Book book, BookDTO bookDTO) {
        book.setName(bookDTO.getName());
        book.setAuthor(bookDTO.getAuthor());
        book.setIsbn(bookDTO.getIsbn());
        // Add other fields here if BookDTO has more fields
    }
}
