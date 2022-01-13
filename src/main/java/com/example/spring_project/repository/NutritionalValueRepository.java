package com.example.spring_project.repository;

import com.example.spring_project.model.NutritionalValue;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class NutritionalValueRepository {
    private JdbcTemplate jdbcTemplate;
    private RowMapper<NutritionalValue> mapper = (resultSet, rowNum) ->
            new NutritionalValue(resultSet.getLong("id"),
                    resultSet.getDouble("energy"),
                    resultSet.getDouble("carbohydrates"),
                    resultSet.getDouble("sugars"),
                    resultSet.getDouble("fats"),
                    resultSet.getDouble("fatty_acids"),
                    resultSet.getDouble("proteins"),
                    resultSet.getDouble("salt"),
                    resultSet.getLong("recipe_id"));

    public NutritionalValueRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void create(NutritionalValue nutritionalValue) {
        String sql = "insert into nutritionalvalues values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, null, nutritionalValue.getEnergy(), nutritionalValue.getCarbohydrates(),
                nutritionalValue.getSugars(), nutritionalValue.getFats(), nutritionalValue.getFatty_acids(),
                nutritionalValue.getProteins(), nutritionalValue.getSalt(), nutritionalValue.getRecipeId());
    }

    public void update(NutritionalValue nutritionalValue) {
        String sql = "UPDATE nutritionalvalues SET energy=?, carbohydrates=?, sugars=?, fats=?, fatty_acids=?, " +
                "proteins=?, salt=?, recipe_id=? WHERE id=?";
        jdbcTemplate.update(sql, nutritionalValue.getEnergy(), nutritionalValue.getCarbohydrates(),
                nutritionalValue.getSugars(), nutritionalValue.getFats(), nutritionalValue.getFatty_acids(),
                nutritionalValue.getProteins(), nutritionalValue.getSalt(), nutritionalValue.getRecipeId(),
                nutritionalValue.getId());
    }

    public List<NutritionalValue> getAllNutritionalValue(){
        String sql = "select * from nutritionalvalues";
        return jdbcTemplate.query(sql, mapper);
    }

    public Optional<NutritionalValue> getNutritionalValueById(Long id){
        String sql = "select * from nutritionalvalues i where i.id = ?";
        List<NutritionalValue> nutritionalValues = jdbcTemplate.query(sql, mapper, id);
        if (!nutritionalValues.isEmpty()){
            return Optional.of(nutritionalValues.get(0));
        } else {
            return Optional.empty();
        }
    }

    public Optional<NutritionalValue> getNutritionalValueByRecipeId(Long recipe_id){
        String sql = "select * from nutritionalvalues i where i.recipe_id = ?";
        List<NutritionalValue> nutritionalValues = jdbcTemplate.query(sql, mapper, recipe_id);
        if (!nutritionalValues.isEmpty()){
            return Optional.of(nutritionalValues.get(0));
        } else {
            return Optional.empty();
        }
    }

    public int deleteNutritionalValueById(Long id) {
        return jdbcTemplate.update("DELETE FROM nutritionalvalues WHERE id=?", id);
    }

}
