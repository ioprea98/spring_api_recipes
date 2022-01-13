package com.example.spring_project.exception.notfound;

public class NotFoundException extends RuntimeException{
    public NotFoundException() {
}

    public NotFoundException(String message) {
        super(message);
    }
}
