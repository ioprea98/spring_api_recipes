package com.example.spring_project.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.*;

public class IngredientRequest {
    @NotBlank(message = "Request body should contain JSON with key name and a unique value")
    @NotNull()
    private String name;

    public IngredientRequest(String name) {
        this.name = name;
    }
    public IngredientRequest() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
