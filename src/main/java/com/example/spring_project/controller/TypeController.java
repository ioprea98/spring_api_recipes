package com.example.spring_project.controller;

import com.example.spring_project.dto.IngredientRequest;
import com.example.spring_project.dto.TypeRequest;
import com.example.spring_project.mapper.TypeMapper;
import com.example.spring_project.model.Type;
import com.example.spring_project.service.TypeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@Validated
@RequestMapping("/api/types")
public class TypeController {
    private TypeService typeService;
    private TypeMapper typeMapper;

    public TypeController(TypeService typeService, TypeMapper typeMapper) {
        this.typeService = typeService;
        this.typeMapper = typeMapper;
    }

    @PostMapping
    public ResponseEntity<Type> addType(
            @Valid
            @RequestBody TypeRequest typeRequest) {
        Type type = typeService.addType(typeMapper.typeRequestToType(typeRequest));
        return ResponseEntity
                .created(URI.create("/api/types/" + type.getId())).body(type);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Type> updateIngredient(
            @Valid
            @RequestBody TypeRequest typeRequest,
            @PathVariable Long id) {
        Type type = typeMapper.typeRequestToType(typeRequest);
        type.setId(id);
        return ResponseEntity.ok(typeService.updateType(type));
    }

    @GetMapping
    public ResponseEntity<List<Type>> getAllTypes(){
        List<Type> allTypes = typeService.getAllTypes();
        if (allTypes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.ok(allTypes);
    }

    @GetMapping("/{id}")
    public Type getTypeById(@PathVariable Long id){
        return typeService.getTypeById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTypeById(@PathVariable Long id) {
        typeService.deleteTypeById(id);
        return new ResponseEntity<>("Type was deleted successfully", HttpStatus.OK);
    }
}
