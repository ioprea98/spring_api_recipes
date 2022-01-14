package com.example.spring_project.mapper;

import com.example.spring_project.dto.RecipeIngredientsRequest;
import com.example.spring_project.dto.RecipeRequest;
import com.example.spring_project.model.Recipe;
import com.example.spring_project.model.RecipeIngredient;
import org.springframework.stereotype.Component;

@Component
public class RecipeMapper {
    public Recipe recipeRequestToRecipe(RecipeRequest recipeRequest) {
        return new Recipe(recipeRequest.getName(), recipeRequest.getDescription(), recipeRequest.getTime());
    }

    public RecipeIngredient recipeIngredientRequestToRecipeIngredient(
            RecipeIngredientsRequest recipeIngredientsRequest) {
        return new RecipeIngredient(recipeIngredientsRequest.getIngredientId(),
                recipeIngredientsRequest.getIngredientQuantity());
    }
}
