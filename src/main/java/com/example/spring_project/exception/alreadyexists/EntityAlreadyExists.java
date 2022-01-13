package com.example.spring_project.exception.alreadyexists;

public class EntityAlreadyExists extends RuntimeException{
    public EntityAlreadyExists() {
    }

    public EntityAlreadyExists(String message) {
        super(message);
    }
}
