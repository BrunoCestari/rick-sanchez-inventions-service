package com.bccestari.rick_sanchez_inventions_service.controllers;

import com.bccestari.rick_sanchez_inventions_service.models.Inventions;
import com.bccestari.rick_sanchez_inventions_service.models.InventionsDto;
import com.bccestari.rick_sanchez_inventions_service.repositories.InventionsRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/inventions")
public class InventionsController {
    @Autowired
    private InventionsRepository repo;

    @GetMapping
    public List<Inventions> getInventions() {
        return repo.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Inventions> getInventions(@PathVariable int id) {
        Inventions invention = repo.findById(id).orElse(null);
        if (invention == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(invention);


    }
    @PostMapping
    public ResponseEntity<Object> createInventions(
            @Valid @RequestBody InventionsDto inventionsDto,
            BindingResult result) {
        double price = 0;
        try {
            price = Double.parseDouble(inventionsDto.getPrice());
        }catch (Exception ex){
            result.addError(new FieldError("inventionsDto", "price",
                    "The price should be a number"));
        }

        if(result.hasErrors()) {
            var errorsList = result.getAllErrors();
            var errorsMap = new HashMap<String, String>();

            for (int i = 0; i < errorsList.size(); i++) {
                var error = (FieldError) errorsList.get(i);
                errorsMap.put(error.getField(), error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(errorsMap);
        }

        Inventions inventions = new Inventions();

        inventions.setName(inventionsDto.getName());
        inventions.setCategory(inventionsDto.getCategory());
        inventions.setPrice(price);
        inventions.setDescription(inventionsDto.getDescription());
        inventions.setCreatedAt(new Date());

        repo.save(inventions);
        return ResponseEntity.ok(inventions);
    }

    @PutMapping("{id}")
    public ResponseEntity<Object> updateInvention(
            @PathVariable int id,
            @Valid @RequestBody InventionsDto inventionDto,
            BindingResult result
    )   {
        Inventions invention = repo.findById(id).orElse(null);
        if (invention == null){
            return ResponseEntity.notFound().build();
        }
        double price = 0;
        try{
            price = Double.parseDouble(inventionDto.getPrice());
        }catch (Exception ex){
            result.addError(new FieldError("inventionDto", "price",
                    "The price should be a number."));
        }
        if(result.hasErrors()) {
            var errorsList = result.getAllErrors();
            var errorsMap = new HashMap<String, String>();

            for (int i = 0; i < errorsList.size(); i++) {
                var error = (FieldError) errorsList.get(i);
                errorsMap.put(error.getField(), error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(errorsMap);
        }

        invention.setName(inventionDto.getName());
        invention.setCategory(inventionDto.getCategory());
        invention.setPrice(price);
        invention.setDescription(inventionDto.getDescription());

        repo.save(invention);

        return ResponseEntity.ok(invention);
    }



}