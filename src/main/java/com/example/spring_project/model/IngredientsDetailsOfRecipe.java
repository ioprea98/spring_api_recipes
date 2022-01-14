package com.example.spring_project.model;

public class IngredientsDetailsOfRecipe {
    private long ingredientId;
    private String ingredientName;
    private String ingredientQuantity;

    public IngredientsDetailsOfRecipe(long ingredientId, String ingredientName, String ingredientQuantity) {
        this.ingredientId = ingredientId;
        this.ingredientName = ingredientName;
        this.ingredientQuantity = ingredientQuantity;
    }

    public long getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(long ingredientId) {
        this.ingredientId = ingredientId;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public String getIngredientQuantity() {
        return ingredientQuantity;
    }

    public void setIngredientQuantity(String ingredientQuantity) {
        this.ingredientQuantity = ingredientQuantity;
    }
}
