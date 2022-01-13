package com.example.spring_project.service;

import com.example.spring_project.exception.alreadyexists.IngredientAlreadyExistsException;
import com.example.spring_project.exception.alreadyexists.RecipeAlreadyExistsException;
import com.example.spring_project.exception.notfound.IngredientNotFoundException;
import com.example.spring_project.exception.notfound.RecipeNotFoundException;
import com.example.spring_project.model.Ingredient;
import com.example.spring_project.model.Recipe;
import com.example.spring_project.repository.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeService {
    private RecipeRepository recipeRepository;

    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public Recipe create(Recipe recipe) {
        checkUniqueRecipe(recipe);
        recipeRepository.create(recipe);
        return getRecipeByName(recipe.getName());
    }

    public Recipe getRecipe(Long id) {
        Optional<Recipe> recipeOptional = recipeRepository.getRecipeById(id);
        if (recipeOptional.isPresent()){
            return recipeOptional.get();
        } else {
            throw new RecipeNotFoundException();
        }
    }

    public List<Recipe> getAllRecipes() {
        return recipeRepository.getAllRecipes();
    }


    public Recipe updateRecipe(Recipe recipe) {
        Optional<Recipe> recipeOptional = recipeRepository.getRecipeById(recipe.getId());
        if (recipeOptional.isEmpty()){
            throw new RecipeNotFoundException();
        }
        checkUniqueRecipe(recipe);
        recipeRepository.update(recipe);
        return getRecipeByName(recipe.getName());
    }

    private void checkUniqueRecipe(Recipe recipe) {
        Optional<Recipe> recipeOptional = recipeRepository.getRecipeByName(recipe.getName());
        if (recipeOptional.isPresent()){
            throw new RecipeAlreadyExistsException();
        }
    }

    private Recipe getRecipeByName(String name) {
        Optional<Recipe> recipeOptional = recipeRepository.getRecipeByName(name);
        if (recipeOptional.isPresent()){
            return recipeOptional.get();
        } else {
            throw new RecipeNotFoundException();
        }
    }
}
