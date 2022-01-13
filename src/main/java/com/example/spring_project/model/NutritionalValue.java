package com.example.spring_project.model;

public class NutritionalValue {
    private long id;
    private double energy;
    private double carbohydrates;
    private double sugars;
    private double fats;
    private double fatty_acids;
    private double proteins;
    private double salt;
    private long recipeId;

    public NutritionalValue(long id, double energy, double carbohydrates, double sugars, double fats, double fatty_acids,
                            double proteins, double salt, long recipeId) {
        this.id = id;
        this.energy = energy;
        this.carbohydrates = carbohydrates;
        this.sugars = sugars;
        this.fats = fats;
        this.fatty_acids = fatty_acids;
        this.proteins = proteins;
        this.salt = salt;
        this.recipeId = recipeId;
    }

    public NutritionalValue(double energy, double carbohydrates, double sugars, double fats, double fatty_acids,
                            double proteins, double salt, long recipeId) {
        this.energy = energy;
        this.carbohydrates = carbohydrates;
        this.sugars = sugars;
        this.fats = fats;
        this.fatty_acids = fatty_acids;
        this.proteins = proteins;
        this.salt = salt;
        this.recipeId = recipeId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public double getSugars() {
        return sugars;
    }

    public void setSugars(double sugars) {
        this.sugars = sugars;
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
