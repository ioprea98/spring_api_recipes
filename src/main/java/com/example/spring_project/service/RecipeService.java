package com.example.spring_project.service;

import com.example.spring_project.exception.RecipeNotFoundException;
import com.example.spring_project.model.Recipe;
import com.example.spring_project.repository.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RecipeService {
    private RecipeRepository recipeRepository;

    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public Recipe getRecipe(Long id) {
        Optional<Recipe> recipeOptional = recipeRepository.getRecipe(id);
        if (recipeOptional.isPresent()){
            return recipeOptional.get();
        } else {
            throw new RecipeNotFoundException();
        }
    }
}
