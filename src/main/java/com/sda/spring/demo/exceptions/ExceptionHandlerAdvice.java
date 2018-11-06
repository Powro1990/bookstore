package com.sda.spring.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.Arrays;

@ControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity handleException(BookNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiError(HttpStatus.NOT_FOUND, "Id not found", Arrays.asList("id", "parametr"), LocalDateTime.now()));
    }

    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity handleCategoryException(CategoryNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiError(HttpStatus.NOT_FOUND, "Category ID not found", Arrays.asList("Id", "parametr"), LocalDateTime.now()));
    }

    @ExceptionHandler(AuthorNotFoundException.class)
    public ResponseEntity handleAuthorException(AuthorNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiError(HttpStatus.NOT_FOUND, "Author ID not found", Arrays.asList("id", "parametr"), LocalDateTime.now()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity inputHandleException(MethodArgumentNotValidException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiError(HttpStatus.BAD_REQUEST, "Wrong data", Arrays.asList("id", "parametr"), LocalDateTime.now()));

    }
}
