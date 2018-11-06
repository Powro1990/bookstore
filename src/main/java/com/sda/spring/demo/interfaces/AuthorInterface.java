package com.sda.spring.demo.interfaces;

import com.sda.spring.demo.model.Author;

import java.util.List;

public interface AuthorInterface {
    List<Author> getAuthors();
    Author addAuthor(Author author);
    Author findById(Long id);
    void delete(Author author);
    void delete(Long id);
}
