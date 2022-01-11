package com.example.spring_project.repository;

import com.example.spring_project.model.Recipe;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RecipeRepository {
    private JdbcTemplate jdbcTemplate;

    public RecipeRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Optional<Recipe> getRecipe(Long id){
        String sql = "select * from recipes r where r.id = ?";
        RowMapper<Recipe> mapper = (resultSet, rowNum) ->
                new Recipe(resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("description"),
                        resultSet.getString("time"));
        List<Recipe> recipes = jdbcTemplate.query(sql, mapper, id);
        if (recipes != null && !recipes.isEmpty()){
            return Optional.of(recipes.get(0));
        } else {
            return Optional.empty();
        }
    }
}
