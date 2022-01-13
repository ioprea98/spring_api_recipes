package com.example.spring_project.repository;

import com.example.spring_project.model.Ingredient;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class IngredientRepository {

    private JdbcTemplate jdbcTemplate;
    private RowMapper<Ingredient> mapper = (resultSet, rowNum) ->
            new Ingredient(resultSet.getLong("id"),
                    resultSet.getString("name"));

    public IngredientRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addIngredient(Ingredient ingredient) {
        String sql = "insert into ingredients values (?, ?)";
        jdbcTemplate.update(sql, null, ingredient.getName());
    }

    public List<Ingredient> getAllIngredients(){
        String sql = "select * from ingredients";
        return jdbcTemplate.query(sql, mapper);
    }

    public Optional<Ingredient> getIngredientById(Long id){
        String sql = "select * from ingredients i where i.id = ?";
        List<Ingredient> ingredients = jdbcTemplate.query(sql, mapper, id);
        if (!ingredients.isEmpty()){
            return Optional.of(ingredients.get(0));
        } else {
            return Optional.empty();
        }
    }

    public Optional<Ingredient> getIngredientByName(String name) {
        String sql = "select * from ingredients i where i.name = ?";
        List<Ingredient> ingredients = jdbcTemplate.query(sql, mapper, name);
        if (!ingredients.isEmpty()){
            return Optional.of(ingredients.get(0));
        } else {
            return Optional.empty();
        }
    }

    public void updateIngredient(Ingredient ingredient) {
        String sql = "UPDATE ingredients SET name=? WHERE id=?";
        jdbcTemplate.update(sql, ingredient.getName(), ingredient.getId());
    }

    public int deleteIngredientById(Long id) {
        return jdbcTemplate.update("DELETE FROM ingredients WHERE id=?", id);
    }

}
