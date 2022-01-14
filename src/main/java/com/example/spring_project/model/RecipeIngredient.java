package com.example.spring_project.model;


public class RecipeIngredient {
    private long recipeId;
    private long ingredientId;
    private String ingredientQuantity;

    public RecipeIngredient(long recipeId, long ingredientId, String ingredientQuantity) {
        this.recipeId = recipeId;
        this.ingredientId = ingredientId;
        this.ingredientQuantity = ingredientQuantity;
    }

    public RecipeIngredient(long ingredientId, String ingredientQuantity) {
        this.ingredientId = ingredientId;
        this.ingredientQuantity = ingredientQuantity;
    }

    public long getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(long recipeId) {
        this.recipeId = recipeId;
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
