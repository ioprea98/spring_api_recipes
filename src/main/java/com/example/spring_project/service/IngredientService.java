package com.example.spring_project.service;

import com.example.spring_project.exception.alreadyexists.IngredientAlreadyExistsException;
import com.example.spring_project.exception.notfound.IngredientNotFoundException;
import com.example.spring_project.exception.notfound.TypeNotFoundException;
import com.example.spring_project.model.Ingredient;
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

    public Ingredient addIngredient(Ingredient ingredient) {
        checkUniqueIngredient(ingredient);
        ingredientRepository.addIngredient(ingredient);
        return getIngredientByName(ingredient.getName());
    }

    public List<Ingredient> getAllIngredients() {
        return ingredientRepository.getAllIngredients();
    }

    public Ingredient getIngredientById(Long id) {
        Optional<Ingredient> ingredientOptional = ingredientRepository.getIngredientById(id);
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

    public Ingredient updateIngredient(Ingredient ingredient) {
        Optional<Ingredient> ingredientOptional = ingredientRepository.getIngredientById(ingredient.getId());
        if (ingredientOptional.isEmpty()){
            throw new IngredientNotFoundException();
        }
        checkUniqueIngredient(ingredient);
        ingredientRepository.updateIngredient(ingredient);
        return getIngredientByName(ingredient.getName());
    }

    private void checkUniqueIngredient(Ingredient ingredient) {
        Optional<Ingredient> ingredientOptional = ingredientRepository.getIngredientByName(ingredient.getName());
        if (ingredientOptional.isPresent()){
            throw new IngredientAlreadyExistsException();
        }
    }

    private Ingredient getIngredientByName(String name) {
        Optional<Ingredient> ingredientOptional = ingredientRepository.getIngredientByName(name);
        if (ingredientOptional.isPresent()){
            return ingredientOptional.get();
        } else {
            throw new IngredientNotFoundException();
        }
    }
}
