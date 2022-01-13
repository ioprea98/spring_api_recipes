package com.example.spring_project.exception.notfound;

import com.example.spring_project.exception.notfound.NotFoundException;

public class IngredientNotFoundException extends NotFoundException {
    public IngredientNotFoundException() {
        super("Ingredient not found");
    }
}
