package com.example.spring_project.exception.alreadyexists;

public class NutritionalValueAlreadyExistsException extends EntityAlreadyExists{
    public NutritionalValueAlreadyExistsException() {
        super("There is already a nutritional values record with this recipe id in the database.");
    }
}
