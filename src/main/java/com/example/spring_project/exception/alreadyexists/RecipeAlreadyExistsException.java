package com.example.spring_project.exception.alreadyexists;

public class RecipeAlreadyExistsException extends EntityAlreadyExists{
    public RecipeAlreadyExistsException() {
        super("There is already a recipe with this name in the database.");
    }

}
