package com.example.spring_project.controller;

import com.example.spring_project.dto.RecipeIngredientsRequest;
import com.example.spring_project.dto.RecipeRequest;
import com.example.spring_project.mapper.RecipeMapper;
import com.example.spring_project.model.Recipe;
import com.example.spring_project.model.RecipeIngredient;
import com.example.spring_project.model.RecipeIngredientsDetails;
import com.example.spring_project.service.RecipeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@Validated
@RequestMapping("/api/recipes")
public class RecipeController {

    private RecipeService recipeService;
    private RecipeMapper recipeMapper;

    public RecipeController(RecipeService recipeService, RecipeMapper recipeMapper) {
        this.recipeService = recipeService;
        this.recipeMapper = recipeMapper;
    }

    @PostMapping
    public ResponseEntity<Recipe> createRecipe(
            @Valid
            @RequestBody RecipeRequest recipeRequest) {
        Recipe recipe = recipeService.create(
                recipeMapper.recipeRequestToRecipe(recipeRequest));
        return ResponseEntity
                .created(URI.create("/api/recipes/" + recipe.getId())).body(recipe);
    }

    @PostMapping("/{id}/ingredients")
    public ResponseEntity<RecipeIngredient> addIRecipeIngredient(
            @Valid
            @RequestBody RecipeIngredientsRequest recipeIngredientsRequest,
            @PathVariable Long id) {
        RecipeIngredient recipeIngredient = recipeMapper.recipeIngredientRequestToRecipeIngredient(
                recipeIngredientsRequest);
        recipeIngredient.setRecipeId(id);
        return ResponseEntity
                .created(URI.create("")).body(recipeService.addRecipeIngredient(recipeIngredient));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Recipe> updateRecipe(
            @Valid
            @RequestBody RecipeRequest recipeRequest,
            @PathVariable Long id) {
        Recipe recipe = recipeMapper.recipeRequestToRecipe(recipeRequest);
        recipe.setId(id);
        return ResponseEntity.ok(recipeService.updateRecipe(recipe));
    }

    @GetMapping
    public ResponseEntity<List<Recipe>> getAllRecipes() {
        List<Recipe> allRecipes = recipeService.getAllRecipes();
        if (allRecipes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(allRecipes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Recipe getRecipe(@PathVariable Long id) {
        return recipeService.getRecipe(id);
    }

    @GetMapping("/{id}/ingredients")
    public ResponseEntity<RecipeIngredientsDetails> getRecipeIngredients(@PathVariable Long id) {
        return ResponseEntity.ok(recipeService.getRecipeIngredients(id));
    }

}
