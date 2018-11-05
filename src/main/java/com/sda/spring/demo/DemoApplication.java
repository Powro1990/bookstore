package com.sda.spring.demo;

import com.sda.spring.demo.model.Author;
import com.sda.spring.demo.model.Book;
import com.sda.spring.demo.model.Category;
import com.sda.spring.demo.repository.AuthorRepository;
import com.sda.spring.demo.repository.BookRepository;
import com.sda.spring.demo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {


    private BookRepository bookRepository;
    private CategoryRepository categoryRepository;
    private AuthorRepository authorRepository;

    @Autowired
    public DemoApplication(BookRepository bookRepository, CategoryRepository categoryRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.categoryRepository = categoryRepository;
        this.authorRepository = authorRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Set<Author> authorSet = new HashSet<>();
        authorSet.add(new Author("Zenek","Zenkowski"));
        Book book = new Book();
        book.setAuthorSet(authorSet);

        book.setTitle("Mistrzowie kebsów");
        book.setCategory(new Category("Kulinaria"));

        bookRepository.save(book);
    }
}
