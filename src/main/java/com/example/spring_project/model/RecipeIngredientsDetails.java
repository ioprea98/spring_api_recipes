package com.example.spring_project.model;

import java.util.List;

public class RecipeIngredientsDetails {
    private long id;
    private String name;
    private String description;
    private String time;
    List<IngredientsDetailsOfRecipe> ingredientsDetailsOfRecipeList;

    public RecipeIngredientsDetails(long id, String name, String description, String time,
                                    List<IngredientsDetailsOfRecipe> ingredientsDetailsOfRecipeList) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.time = time;
        this.ingredientsDetailsOfRecipeList = ingredientsDetailsOfRecipeList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public List<IngredientsDetailsOfRecipe> getIngredientsDetailsOfRecipeList() {
        return ingredientsDetailsOfRecipeList;
    }

    public void setIngredientsDetailsOfRecipeList(List<IngredientsDetailsOfRecipe> ingredientsDetailsOfRecipeList) {
        this.ingredientsDetailsOfRecipeList = ingredientsDetailsOfRecipeList;
    }
}
