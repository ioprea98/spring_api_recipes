package com.example.spring_project.model;

public class Recipe {
    private long id;
    private String name;
    private String description;
    private String time;

    public Recipe(long id, String name, String description, String time) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.time = time;
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
}
