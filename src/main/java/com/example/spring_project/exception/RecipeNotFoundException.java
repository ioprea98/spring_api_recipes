package com.example.spring_project.exception;

public class RecipeNotFoundException extends NotFoundException{
    public RecipeNotFoundException() {
        super("Recipe not found");
    }
}
