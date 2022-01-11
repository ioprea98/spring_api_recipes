package com.example.spring_project.repository;

import com.example.spring_project.model.Ingredient;
import com.example.spring_project.model.Recipe;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class IngredientRepository {

    private JdbcTemplate jdbcTemplate;

    public IngredientRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addIngredient(Ingredient ingredient) {
        String sql = "insert into ingredients values (?, ?)";
        jdbcTemplate.update(sql, null, ingredient.getName());
    }

    public List<Ingredient> getAllIngredients(){
        String sql = "select * from ingredients";
        RowMapper<Ingredient> mapper = (resultSet, rowNum) ->
                new Ingredient(resultSet.getLong("id"),
                        resultSet.getString("name"));
        return jdbcTemplate.query(sql, mapper);
    }

    public Optional<Ingredient> getIngredient(Long id){
        String sql = "select * from ingredients i where i.id = ?";
        RowMapper<Ingredient> mapper = (resultSet, rowNum) ->
                new Ingredient(resultSet.getLong("id"),
                        resultSet.getString("name"));
        List<Ingredient> ingredients = jdbcTemplate.query(sql, mapper, id);
        if (ingredients != null && !ingredients.isEmpty()){
            return Optional.of(ingredients.get(0));
        } else {
            return Optional.empty();
        }
    }
    public int deleteIngredientById(Long id) {
        return jdbcTemplate.update("DELETE FROM ingredients WHERE id=?", id);
    }
    public int updateIngredient(Ingredient ingredient) {
        String sql = "UPDATE ingredients SET name=? WHERE id=?";
        return jdbcTemplate.update(sql, ingredient.getName(), ingredient.getId());
    }
}
