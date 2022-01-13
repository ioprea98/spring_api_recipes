package com.example.spring_project.repository;

import com.example.spring_project.model.Type;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TypeRepository {
    private JdbcTemplate jdbcTemplate;

    public TypeRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    private RowMapper<Type> mapper = (resultSet, rowNum) ->
            new Type(resultSet.getLong("id"),
                    resultSet.getString("name"));

    public void addType(Type type){
        String sql = "insert into types values (?, ?)";
        jdbcTemplate.update(sql, null, type.getName());
    }

    public List<Type> getAllTypes() {
        String sql = "select * from types";
        return jdbcTemplate.query(sql, mapper);
    }

    public Optional<Type> getTypeById(Long id){
        String sql = "select * from types where id = ?";
        List<Type> types = jdbcTemplate.query(sql, mapper, id);
        if (!types.isEmpty()){
            return Optional.of(types.get(0));
        } else {
            return Optional.empty();
        }
    }
    public Optional<Type> getTypeByName(String name){
        String sql = "select * from types where name = ?";
        List<Type> types = jdbcTemplate.query(sql, mapper, name);
        if (!types.isEmpty()){
            return Optional.of(types.get(0));
        } else {
            return Optional.empty();
        }
    }

    public void updateType(Type type) {
        String sql = "UPDATE types SET name=? WHERE id=?";
        jdbcTemplate.update(sql, type.getName(), type.getId());
    }

    public int deleteTypeById(Long id) {
        return jdbcTemplate.update("DELETE FROM types WHERE id=?", id);
    }


}
