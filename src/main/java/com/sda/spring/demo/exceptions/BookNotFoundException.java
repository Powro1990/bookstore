package com.sda.spring.demo.exceptions;

public class BookNotFoundException extends RuntimeException {

    public BookNotFoundException(Long id){
        super("Nie ma takiej ksiazki: " + id);
    }
}
