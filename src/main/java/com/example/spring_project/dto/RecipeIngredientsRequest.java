package com.example.spring_project.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

public class RecipeIngredientsRequest {
    @NotNull
    private Long ingredientId;
    @NotNull
    @NotBlank
    private String ingredientQuantity;

    public RecipeIngredientsRequest() {
    }

    public RecipeIngredientsRequest(Long ingredientId, String ingredientQuantity) {
        this.ingredientId = ingredientId;
        this.ingredientQuantity = ingredientQuantity;
    }

    public long getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(long ingredientId) {
        this.ingredientId = ingredientId;
    }

    public String getIngredientQuantity() {
        return ingredientQuantity;
    }

    public void setIngredientQuantity(String ingredientQuantity) {
        this.ingredientQuantity = ingredientQuantity;
    }
}
