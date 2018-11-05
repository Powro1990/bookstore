package com.sda.spring.demo.controller;

import com.sda.spring.demo.model.Author;
import com.sda.spring.demo.model.Book;
import com.sda.spring.demo.model.Category;
import com.sda.spring.demo.repository.AuthorRepository;
import com.sda.spring.demo.repository.BookRepository;
import com.sda.spring.demo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String hello() {
        return "Hello world";
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        return "testujemy stringa";
    }

    @RequestMapping(value = "/api/books", method = RequestMethod.POST)
    public Book addBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    @RequestMapping(value = "/api/books", method = RequestMethod.GET)
    public List<Book> books() {
        return bookRepository.findAll();
    }

    @RequestMapping(value = "/api/authors", method = RequestMethod.GET)
    public List<Author> authors(){
        return authorRepository.findAll();
    }

    @RequestMapping(value = "/api/authors", method = RequestMethod.POST)
    public Author addAuthor(@RequestBody Author author){
        return authorRepository.save(author);
    }

    @RequestMapping(value = "/api/category",method = RequestMethod.POST)
    public Category addCategory(@RequestBody Category category){
        return categoryRepository.save(category);
    }

    @RequestMapping(value = "/api/category",method = RequestMethod.GET)
    public List<Category> categories(){
        return categoryRepository.findAll();
    }


}
