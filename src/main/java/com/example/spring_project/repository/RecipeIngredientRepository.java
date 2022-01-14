package com.example.spring_project.repository;

import com.example.spring_project.model.IngredientsDetailsOfRecipe;
import com.example.spring_project.model.RecipeIngredient;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RecipeIngredientRepository {
    private JdbcTemplate jdbcTemplate;

    private RowMapper<IngredientsDetailsOfRecipe> ingDetailsMapper = (resultSet, rowNum) ->
            new IngredientsDetailsOfRecipe(resultSet.getLong("ingridient_id"),
                    resultSet.getString("ingredient_name"),
                    resultSet.getString("quantity"));

    private RowMapper<RecipeIngredient> recipeIngredientMapper = (resultSet, rowNum) ->
            new RecipeIngredient(resultSet.getLong("recipe_id"),
                    resultSet.getLong("ingridient_id"),
                    resultSet.getString("quantity"));

    public RecipeIngredientRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<IngredientsDetailsOfRecipe> getIngredientDetailsOfRecipe(long recipe_id) {
        String sql = "SELECT ri.ingridient_id, (select name from ingredients where id = ri.ingridient_id) " +
                "ingredient_name, ri.quantity\n" +
                "from recipesingridients ri inner join recipes r on r.id=ri.recipe_id where r.id=?;";
        return jdbcTemplate.query(sql, ingDetailsMapper, recipe_id);
    }

    public void create(RecipeIngredient recipeIngredient) {
        String sql = "INSERT INTO recipesingridients  VALUES (?, ?, ?);";
        jdbcTemplate.update(sql, recipeIngredient.getIngredientId(), recipeIngredient.getRecipeId(),
                recipeIngredient.getIngredientQuantity());
    }

    public Optional<RecipeIngredient> get(RecipeIngredient recipeIngredient) {
        String sql = "SELECT * FROM recipesingridients where recipe_id=? and ingridient_id=?; ";
        List<RecipeIngredient> recipeIngredients =  jdbcTemplate.query(sql, recipeIngredientMapper,
                recipeIngredient.getRecipeId(), recipeIngredient.getIngredientId());
        if (!recipeIngredients.isEmpty()){
            return Optional.of(recipeIngredients.get(0));
        } else {
            return Optional.empty();
        }
    }
}
