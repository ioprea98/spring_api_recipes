package com.example.spring_project.exception.notfound;

import com.example.spring_project.exception.notfound.NotFoundException;

public class RecipeNotFoundException extends NotFoundException {
    public RecipeNotFoundException() {
        super("Recipe not found");
    }
}
