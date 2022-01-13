package com.example.spring_project.exception.notfound;

public class NutritionalValueNotFound extends NotFoundException{
    public NutritionalValueNotFound() {
        super("Nutritional Value not found.");
    }
}
