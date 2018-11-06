package com.sda.spring.demo.exceptions;

public class AuthorNotFoundException extends RuntimeException {
    public AuthorNotFoundException(Long id){
        super("Nie ma takiego autora: " + id);
    }
}
