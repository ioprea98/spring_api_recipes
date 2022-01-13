package com.example.spring_project.dto;

import com.example.spring_project.model.Type;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class TypeRequest {
    @NotBlank(message = "Request body should contain JSON with key name and a valid String value")
    @NotNull
    private String name;
    public TypeRequest() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TypeRequest(String name) {
        this.name = name;
    }
}
