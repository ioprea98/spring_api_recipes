package com.example.spring_project.exception.notfound;

public class RecipeIngredientNotFoundException extends NotFoundException{
    public RecipeIngredientNotFoundException() {
        super("RecipeIngredientNotFound");
    }
}
