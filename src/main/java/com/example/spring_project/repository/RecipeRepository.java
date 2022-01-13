package com.example.spring_project.repository;

import com.example.spring_project.model.Ingredient;
import com.example.spring_project.model.NutritionalValue;
import com.example.spring_project.model.Recipe;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RecipeRepository {
    private JdbcTemplate jdbcTemplate;
    private RowMapper<Recipe> mapper = (resultSet, rowNum) ->
            new Recipe(resultSet.getLong("id"),
                    resultSet.getString("name"),
                    resultSet.getString("description"),
                    resultSet.getString("time"));

    public RecipeRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void create(Recipe recipe) {
        String sql = "insert into recipes values (?, ?, ?, ?)";
        jdbcTemplate.update(sql, null, recipe.getName(), recipe.getDescription(), recipe.getTime());
    }

    public void update(Recipe recipe) {
        String sql = "UPDATE recipes SET name=?, description=?, time=? WHERE id=?";
        jdbcTemplate.update(sql, recipe.getName(), recipe.getDescription(), recipe.getTime(), recipe.getId());
    }

    public Optional<Recipe> getRecipeById(Long id){
        String sql = "select * from recipes r where r.id = ?";
        List<Recipe> recipes = jdbcTemplate.query(sql, mapper, id);
        if (!recipes.isEmpty()){
            return Optional.of(recipes.get(0));
        } else {
            return Optional.empty();
        }
    }

    public Optional<Recipe> getRecipeByName(String name) {
        String sql = "select * from recipes i where i.name = ?";
        List<Recipe> recipes = jdbcTemplate.query(sql, mapper, name);
        if (!recipes.isEmpty()){
            return Optional.of(recipes.get(0));
        } else {
            return Optional.empty();
        }
    }

    public List<Recipe> getAllRecipes(){
        String sql = "select * from recipes ";
        return jdbcTemplate.query(sql, mapper);
    }

//    public int deleteRecipeById(Long id) {
//        return jdbcTemplate.update("DELETE FROM recipes WHERE id=?", id);
//    }
}
