package com.example.spring_project.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class NutritionalValueRequest {
    @NotNull
    @Min(0)
    private Double energy;
    @NotNull
    @Min(0)
    private Double carbohydrates;
    @NotNull
    @Min(0)
    private Double sugar;
    @NotNull
    @Min(0)
    private Double fats;
    @NotNull
    @Min(0)
    private Double fatty_acids;
    @NotNull
    @Min(0)
    private Double proteins;
    @NotNull
    @Min(0)
    private Double salt;
    @NotNull
    private Long recipeId;

    public NutritionalValueRequest() {

    }

    public NutritionalValueRequest(double energy, double carbohydrates, double sugar, double fats, double fatty_acids,
                                   double proteins, double salt, long recipeId) {
        this.energy = energy;
        this.carbohydrates = carbohydrates;
        this.sugar = sugar;
        this.fats = fats;
        this.fatty_acids = fatty_acids;
        this.proteins = proteins;
        this.salt = salt;
        this.recipeId = recipeId;
    }

    public double getEnergy() {
        return energy;
    }

    public void setEnergy(double energy) {
        this.energy = energy;
    }

    public double getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(double carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public double getSugar() {
        return sugar;
    }

    public void setSugar(double sugar) {
        this.sugar = sugar;
    }

    public double getFats() {
        return fats;
    }

    public void setFats(double fats) {
        this.fats = fats;
    }

    public double getFatty_acids() {
        return fatty_acids;
    }

    public void setFatty_acids(double fatty_acids) {
        this.fatty_acids = fatty_acids;
    }

    public double getProteins() {
        return proteins;
    }

    public void setProteins(double proteins) {
        this.proteins = proteins;
    }

    public double getSalt() {
        return salt;
    }

    public void setSalt(double salt) {
        this.salt = salt;
    }

    public long getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(long recipeId) {
        this.recipeId = recipeId;
    }
}
