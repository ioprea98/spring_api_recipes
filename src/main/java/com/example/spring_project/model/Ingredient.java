package com.example.spring_project.model;

public class Ingredient {
    private long id;
    private String name;

    public Ingredient() {}

    public Ingredient(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Ingredient(String name) {
        this.name = name;
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
}
