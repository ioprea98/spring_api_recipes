package com.example.spring_project.controller;

import com.example.spring_project.dto.IngredientRequest;
import com.example.spring_project.mapper.IngredientMapper;
import com.example.spring_project.model.Ingredient;
import com.example.spring_project.model.Recipe;
import com.example.spring_project.service.IngredientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@Validated
@RequestMapping("/api/ingredients")
public class IngredientController {
    private IngredientService ingredientService;
    private IngredientMapper ingredientMapper;

    public IngredientController(IngredientService ingredientService, IngredientMapper ingredientMapper) {
        this.ingredientService = ingredientService;
        this.ingredientMapper = ingredientMapper;
    }

    @PostMapping
    public ResponseEntity<Ingredient> addIngredient(
            @Valid
            @RequestBody IngredientRequest ingredientRequest) {
        Ingredient ingredient = ingredientMapper.ingredientRequestToIngredient(ingredientRequest);
        ingredientService.addIngredient(ingredient);
        return ResponseEntity
                .created(null)
                .build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateIngredient(
            @Valid
            @RequestBody IngredientRequest ingredientRequest,
            @PathVariable Long id) {
        Ingredient ingredient = ingredientMapper.ingredientRequestToIngredient(ingredientRequest);
        ingredient.setId(id);
        ingredientService.updateIngredient(ingredient);
        return new ResponseEntity<String>("Ingredient was updated successfully.", HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Ingredient>> getAllIngredients() {
        List<Ingredient> allIngredients = ingredientService.getAllIngredients();
        if (allIngredients.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(allIngredients, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Ingredient getIngredient(@PathVariable Long id) {
        return ingredientService.getIngredient(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteIngredient(@PathVariable Long id) {
        ingredientService.deleteIngredientById(id);
        return new ResponseEntity<>("Tutorial was deleted successfully.", HttpStatus.OK);
    }
}
