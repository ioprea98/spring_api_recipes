package com.example.spring_project.mapper;

import com.example.spring_project.dto.IngredientRequest;
import com.example.spring_project.model.Ingredient;
import org.springframework.stereotype.Component;

@Component
public class IngredientMapper {
    public Ingredient ingredientRequestToIngredient(IngredientRequest ingredientRequest) {
        return new Ingredient(ingredientRequest.getName());
    }
}
