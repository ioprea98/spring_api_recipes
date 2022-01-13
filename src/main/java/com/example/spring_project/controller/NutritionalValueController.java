package com.example.spring_project.controller;

import com.example.spring_project.dto.NutritionalValueRequest;
import com.example.spring_project.mapper.NutritionalValueMapper;
import com.example.spring_project.model.NutritionalValue;
import com.example.spring_project.service.NutritionalValueService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@Validated
@RequestMapping("/api/nutritionalvalues")
public class NutritionalValueController {
    private NutritionalValueMapper nutritionalValueMapper;
    private NutritionalValueService nutritionalValueService;

    public NutritionalValueController(NutritionalValueMapper nutritionalValueMapper,
                                      NutritionalValueService nutritionalValueService) {
        this.nutritionalValueMapper = nutritionalValueMapper;
        this.nutritionalValueService = nutritionalValueService;
    }

    @PostMapping
    public ResponseEntity<NutritionalValue> create(
            @Valid
            @RequestBody NutritionalValueRequest nutritionalValueRequest) {
        NutritionalValue nutritionalValue = nutritionalValueService.create(
                nutritionalValueMapper.nutritionalValueRequestToNutritionalValue(nutritionalValueRequest));
        return ResponseEntity
                .created(URI.create("/api/nutritionalvalues/" + nutritionalValue.getId())).body(nutritionalValue);
    }

    @PutMapping("/{id}")
    public ResponseEntity<NutritionalValue> updateNutritionalValue(
            @Valid
            @RequestBody NutritionalValueRequest nutritionalValueRequest,
            @PathVariable Long id) {
        NutritionalValue nutritionalValue = nutritionalValueMapper.nutritionalValueRequestToNutritionalValue(
                nutritionalValueRequest);
        nutritionalValue.setId(id);
        return ResponseEntity.ok(nutritionalValueService.updateNutritionalValue(nutritionalValue));
    }

    @GetMapping
    public ResponseEntity<List<NutritionalValue>> getAllNutritionalValues() {
        List<NutritionalValue> nutritionalValues = nutritionalValueService.getAllNutritionalValues();
        if (nutritionalValues.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(nutritionalValues, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public NutritionalValue getNutritionalValueById(@PathVariable Long id) {
        return nutritionalValueService.getNutritionalValueById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteNutritionalValueById(@PathVariable Long id) {
        nutritionalValueService.deleteNutritionalValueById(id);
        return new ResponseEntity<>("Nutritional value record  was deleted successfully.", HttpStatus.OK);
    }
}
