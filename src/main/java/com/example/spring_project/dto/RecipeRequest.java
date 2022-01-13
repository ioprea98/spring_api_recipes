package com.example.spring_project.dto;

import javax.validation.constraints.NotBlank;

public class RecipeRequest {
    @NotBlank
    private String name;
    @NotBlank
    private String description;
    @NotBlank
    private String time;

    public RecipeRequest() {
    }

    public RecipeRequest(String name, String description, String time) {
        this.name = name;
        this.description = description;
        this.time = time;
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
