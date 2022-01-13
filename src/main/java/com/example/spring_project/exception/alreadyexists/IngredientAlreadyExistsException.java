package com.example.spring_project.exception.alreadyexists;

public class IngredientAlreadyExistsException extends EntityAlreadyExists{
    public IngredientAlreadyExistsException() {
        super("There is already an ingredient with this name in the database.");
    }
}
