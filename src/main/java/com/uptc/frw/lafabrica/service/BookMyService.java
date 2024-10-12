package com.uptc.frw.lafabrica.service;

import com.uptc.frw.lafabrica.model.BookMy;
import com.uptc.frw.lafabrica.repository.BookMyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookMyService {

    private final BookMyRepository bookMyRepository;

    @Autowired
    public BookMyService(BookMyRepository bookMyRepository) {
        this.bookMyRepository = bookMyRepository;
    }

    public List<BookMy> getAllBooks() {
        return bookMyRepository.findAll();
    }

    public Optional<BookMy> getBookById(Long id) {
        return bookMyRepository.findById(id);
    }

    public BookMy createBook(BookMy bookMy) {
        return bookMyRepository.save(bookMy);
    }

    public BookMy updateBook(Long id, BookMy bookMy) {
        bookMy.setId(id);
        return bookMyRepository.save(bookMy);
    }

    public void deleteBook(Long id) {
        bookMyRepository.deleteById(id);
    }
}
