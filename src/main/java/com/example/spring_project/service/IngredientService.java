package com.example.spring_project.service;

import com.example.spring_project.exception.IngredientNotFoundException;
import com.example.spring_project.exception.RecipeNotFoundException;
import com.example.spring_project.model.Ingredient;
import com.example.spring_project.model.Recipe;
import com.example.spring_project.repository.IngredientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngredientService {
    private IngredientRepository ingredientRepository;

    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    public void addIngredient(Ingredient ingredient) {
        ingredientRepository.addIngredient(ingredient);
    }
    public List<Ingredient> getAllIngredients() {
        return ingredientRepository.getAllIngredients();
    }
    public Ingredient getIngredient(Long id) {
        Optional<Ingredient> ingredientOptional = ingredientRepository.getIngredient(id);
        if (ingredientOptional.isPresent()){
            return ingredientOptional.get();
        } else {
            throw new IngredientNotFoundException();
        }
    }
    public void deleteIngredientById(Long id) {
        int result = ingredientRepository.deleteIngredientById(id);
        if (result == 0) {
            throw new IngredientNotFoundException();
        }
    }

    public void updateIngredient(Ingredient ingredient) {
        int result = ingredientRepository.updateIngredient(ingredient);
        if (result == 0) {
            throw new IngredientNotFoundException();
        }
    }

}
