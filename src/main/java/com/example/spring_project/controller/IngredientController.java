package com.example.spring_project.controller;

import com.example.spring_project.dto.IngredientRequest;
import com.example.spring_project.mapper.IngredientMapper;
import com.example.spring_project.model.Ingredient;
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
        Ingredient ingredient = ingredientService.addIngredient(
                ingredientMapper.ingredientRequestToIngredient(ingredientRequest));
        return ResponseEntity
                .created(URI.create("/api/ingredients/" + ingredient.getId())).body(ingredient);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ingredient> updateIngredient(
            @Valid
            @RequestBody IngredientRequest ingredientRequest,
            @PathVariable Long id) {
        Ingredient ingredient = ingredientMapper.ingredientRequestToIngredient(ingredientRequest);
        ingredient.setId(id);
        return ResponseEntity.ok(ingredientService.updateIngredient(ingredient));
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
    public Ingredient getIngredientById(@PathVariable Long id) {
        return ingredientService.getIngredientById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteIngredientById(@PathVariable Long id) {
        ingredientService.deleteIngredientById(id);
        return new ResponseEntity<>("Ingredient  was deleted successfully.", HttpStatus.OK);
    }
}
