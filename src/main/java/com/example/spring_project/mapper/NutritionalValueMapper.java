package com.example.spring_project.mapper;

import com.example.spring_project.dto.NutritionalValueRequest;
import com.example.spring_project.model.NutritionalValue;
import org.springframework.stereotype.Component;

@Component
public class NutritionalValueMapper {
    public NutritionalValue nutritionalValueRequestToNutritionalValue(NutritionalValueRequest nutritionalValueRequest) {
        return new NutritionalValue(nutritionalValueRequest.getEnergy(), nutritionalValueRequest.getCarbohydrates(),
                nutritionalValueRequest.getSugar(), nutritionalValueRequest.getFats(),
                nutritionalValueRequest.getFatty_acids(), nutritionalValueRequest.getProteins(),
                nutritionalValueRequest.getSalt(), nutritionalValueRequest.getRecipeId());
    }
}
