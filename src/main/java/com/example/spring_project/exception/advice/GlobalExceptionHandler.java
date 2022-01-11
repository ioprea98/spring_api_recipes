package com.example.spring_project.exception.advice;

import com.example.spring_project.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<String> handle(NotFoundException exception) {

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(exception.getMessage() + " at " + LocalDateTime.now());
    }

    @ExceptionHandler({MethodArgumentNotValidException.class, SQLException.class})
    public ResponseEntity<String> handle(MethodArgumentNotValidException e) {
        return ResponseEntity.badRequest()
                .body("Invalid value : " + e.getFieldError().getRejectedValue() +
                        " for field " + e.getFieldError().getField() +
                        " with message " + e.getFieldError().getDefaultMessage());
    }

//    @ExceptionHandler({SQLIntegrityConstraintViolationException.class})
//    public ResponseEntity<String> handle(SQLIntegrityConstraintViolationException e) {
//        return ResponseEntity.badRequest()
//                .body("Cannot insert duplicate values : " + e.getMessage());
//    }
}
