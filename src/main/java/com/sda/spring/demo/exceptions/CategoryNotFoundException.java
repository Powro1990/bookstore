package com.sda.spring.demo.exceptions;

public class CategoryNotFoundException extends RuntimeException {

    public CategoryNotFoundException(Long id){
        super("nie ma takiej kategorii: " + id);
    }
}
