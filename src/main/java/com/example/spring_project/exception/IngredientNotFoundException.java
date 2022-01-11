package com.example.spring_project.exception;

public class IngredientNotFoundException extends NotFoundException{
    public IngredientNotFoundException() {
        super("Ingredient not found");
    }
}
