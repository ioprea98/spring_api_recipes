package com.example.spring_project.service;

import com.example.spring_project.exception.alreadyexists.NutritionalValueAlreadyExistsException;
import com.example.spring_project.exception.notfound.NutritionalValueNotFound;
import com.example.spring_project.exception.notfound.TypeNotFoundException;
import com.example.spring_project.model.Ingredient;
import com.example.spring_project.model.NutritionalValue;
import com.example.spring_project.repository.NutritionalValueRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NutritionalValueService {
    private NutritionalValueRepository nutritionalValueRepository;

    public NutritionalValueService(NutritionalValueRepository nutritionalValueRepository) {
        this.nutritionalValueRepository = nutritionalValueRepository;
    }

    public NutritionalValue create(NutritionalValue nutritionalValue) {
        checkUniqueRecipeId(nutritionalValue.getRecipeId());
        nutritionalValueRepository.create(nutritionalValue);
        return getNutritionalValueByRecipeId(nutritionalValue.getRecipeId());
    }
    public NutritionalValue updateNutritionalValue(NutritionalValue nutritionalValue) {
        Optional<NutritionalValue> nutritionalValueOptional = nutritionalValueRepository.
                getNutritionalValueById(nutritionalValue.getId());
        if (nutritionalValueOptional.isEmpty()){
            throw new NutritionalValueNotFound();
        }
        NutritionalValue existingRecord = nutritionalValueOptional.get();
        if (existingRecord.getRecipeId() != nutritionalValue.getRecipeId()){
            checkUniqueRecipeId(nutritionalValue.getRecipeId());
        }
        nutritionalValueRepository.update(nutritionalValue);
        return getNutritionalValueByRecipeId(nutritionalValue.getRecipeId());
    }

    public List<NutritionalValue> getAllNutritionalValues() {
        return nutritionalValueRepository.getAllNutritionalValue();
    }

    public NutritionalValue getNutritionalValueById(Long id) {
        Optional<NutritionalValue> nutritionalValueOptional = nutritionalValueRepository.getNutritionalValueById(id);
        if (nutritionalValueOptional.isPresent()){
            return nutritionalValueOptional.get();
        } else {
            throw new NutritionalValueNotFound();
        }
    }

    public void deleteNutritionalValueById(Long id) {
        int result = nutritionalValueRepository.deleteNutritionalValueById(id);
        if (result == 0) {
            throw new NutritionalValueNotFound();
        }
    }

    private void checkUniqueRecipeId(Long recipeId) {
        Optional<NutritionalValue> optionalNutritionalValue =
                nutritionalValueRepository.getNutritionalValueByRecipeId(recipeId);
        if (optionalNutritionalValue.isPresent()){
            throw new NutritionalValueAlreadyExistsException();
        }
    }

    private NutritionalValue getNutritionalValueByRecipeId(Long recipe_id) {
        Optional<NutritionalValue> nutritionalValueOptional =
                nutritionalValueRepository.getNutritionalValueByRecipeId(recipe_id);
        if (nutritionalValueOptional.isPresent()){
            return nutritionalValueOptional.get();
        } else {
            throw new NutritionalValueNotFound();
        }
    }
}
