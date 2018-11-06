package com.sda.spring.demo.controller;

import com.sda.spring.demo.model.Author;
import com.sda.spring.demo.model.Book;
import com.sda.spring.demo.model.Category;
import com.sda.spring.demo.repository.AuthorRepository;
import com.sda.spring.demo.repository.BookRepository;
import com.sda.spring.demo.repository.CategoryRepository;
import com.sda.spring.demo.service.AuthorService;
import com.sda.spring.demo.service.BookService;
import com.sda.spring.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {

    @Autowired
    private BookService bookService;
    @Autowired
    private AuthorService authorService;
    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String hello() {
        return "Hello world";
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        return "testujemy stringa";
    }

    @RequestMapping(value = "/api/books", method = RequestMethod.POST)
    public ResponseEntity<Book> addBook(@Valid @RequestBody Book book) {
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.addBook(book));
    }

    @RequestMapping(value = "/api/books", method = RequestMethod.GET)
    public List<Book> books() {
        return bookService.getBooks();
    }

    @RequestMapping(value = "/api/authors", method = RequestMethod.GET)
    public List<Author> authors(){
        return authorService.getAuthors();
    }

    @RequestMapping(value = "/api/authors", method = RequestMethod.POST)
    public ResponseEntity<Author> addAuthor(@Valid @RequestBody Author author){
        return ResponseEntity.status(HttpStatus.CREATED).body(authorService.addAuthor(author));
    }

    @RequestMapping(value = "/api/category",method = RequestMethod.POST)
    public ResponseEntity<Category> addCategory(@Valid @RequestBody Category category){
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.addCategory(category));
    }

    @RequestMapping(value = "/api/category",method = RequestMethod.GET)
    public List<Category> categories(){
        return categoryService.getCategories();
    }

    @RequestMapping(value = "/api/books/{id}", method = RequestMethod.GET)
    public ResponseEntity<Book> book(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(bookService.findById(id));
    }

    @RequestMapping(value = "/api/category/{id}", method = RequestMethod.GET)
    public ResponseEntity<Category> category(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.findById(id));
    }

    @RequestMapping(value = "/api/authors/{id}", method = RequestMethod.GET)
    public ResponseEntity<Author> author(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(authorService.findById(id));
    }

}
