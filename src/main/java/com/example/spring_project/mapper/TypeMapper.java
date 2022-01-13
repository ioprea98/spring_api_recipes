package com.example.spring_project.mapper;

import com.example.spring_project.dto.IngredientRequest;
import com.example.spring_project.dto.TypeRequest;
import com.example.spring_project.model.Type;
import org.springframework.stereotype.Component;

@Component
public class TypeMapper {
    public Type typeRequestToType(TypeRequest typeRequest) {
        return new Type(typeRequest.getName());
    }
}
