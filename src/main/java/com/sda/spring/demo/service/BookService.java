package com.sda.spring.demo.service;

import com.sda.spring.demo.exceptions.BookNotFoundException;
import com.sda.spring.demo.interfaces.BookInterface;
import com.sda.spring.demo.model.Book;
import com.sda.spring.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements BookInterface {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book findById(Long id) {
        return bookRepository.findById(id).orElseThrow(
                () -> new BookNotFoundException(id)
        );
    }

    @Override
    public void delete(Book book) {

    }

    @Override
    public void delete(Long id) {

    }

    public Book getBookByTitle(String title) {
        return bookRepository.findByTitle(title);
    }
}
