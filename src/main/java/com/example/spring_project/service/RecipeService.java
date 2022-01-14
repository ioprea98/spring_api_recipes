package com.example.spring_project.service;

import com.example.spring_project.exception.alreadyexists.RecipeAlreadyExistsException;
import com.example.spring_project.exception.notfound.IngredientNotFoundException;
import com.example.spring_project.exception.notfound.RecipeIngredientNotFoundException;
import com.example.spring_project.exception.notfound.RecipeNotFoundException;
import com.example.spring_project.model.*;
import com.example.spring_project.repository.IngredientRepository;
import com.example.spring_project.repository.RecipeRepository;
import com.example.spring_project.repository.RecipeIngredientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeService {
    private RecipeRepository recipeRepository;
    private RecipeIngredientRepository recipeIngredientRepository;
    private IngredientRepository ingredientRepository;

    public RecipeService(RecipeRepository recipeRepository, RecipeIngredientRepository recipeIngredientRepository,
                         IngredientRepository ingredientRepository) {
        this.recipeRepository = recipeRepository;
        this.recipeIngredientRepository = recipeIngredientRepository;
        this.ingredientRepository = ingredientRepository;
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

    public RecipeIngredientsDetails getRecipeIngredients(Long recipeId) {
        Optional<Recipe> recipeOptional = recipeRepository.getRecipeById(recipeId);
        if (recipeOptional.isEmpty()){
            throw new RecipeNotFoundException();
        }
        Recipe recipe = recipeOptional.get();
        List<IngredientsDetailsOfRecipe> ingredientsDetailsOfRecipeList =
                recipeIngredientRepository.getIngredientDetailsOfRecipe(recipeId);
        return new RecipeIngredientsDetails(recipe.getId(), recipe.getName(),
                recipe.getDescription(), recipe.getTime(), ingredientsDetailsOfRecipeList);
    }

    public RecipeIngredient addRecipeIngredient(RecipeIngredient recipeIngredient) {
        Optional<Recipe> recipeOptional = recipeRepository.getRecipeById(recipeIngredient.getRecipeId());
        if (recipeOptional.isEmpty()){
            throw new RecipeNotFoundException();
        }
        Optional<Ingredient> optionalIngredient = ingredientRepository.getIngredientById(
                recipeIngredient.getIngredientId());
        if (optionalIngredient.isEmpty()){
            throw new IngredientNotFoundException();
        }
        recipeIngredientRepository.create(recipeIngredient);
        return getRecipeIngredient(recipeIngredient);
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

    private RecipeIngredient getRecipeIngredient(RecipeIngredient recipeIngredient) {
        Optional<RecipeIngredient> optionalRecipeIngredient = recipeIngredientRepository.get(recipeIngredient);
        if (optionalRecipeIngredient.isPresent()){
            return optionalRecipeIngredient.get();
        } else {
            throw new RecipeIngredientNotFoundException();
        }
    }
}
