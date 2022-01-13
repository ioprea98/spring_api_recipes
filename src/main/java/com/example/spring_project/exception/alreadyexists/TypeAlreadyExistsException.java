package com.example.spring_project.exception.alreadyexists;

public class TypeAlreadyExistsException extends EntityAlreadyExists{
    public TypeAlreadyExistsException() {
        super("There is already a type with this name in the database.");
    }
}
