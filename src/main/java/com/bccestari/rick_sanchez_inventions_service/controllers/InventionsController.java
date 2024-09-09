package com.bccestari.rick_sanchez_inventions_service.controllers;

import com.bccestari.rick_sanchez_inventions_service.models.Invention;
import com.bccestari.rick_sanchez_inventions_service.models.InventionDto;
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
    public List<Invention> getInventions() {
        return repo.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Invention> getInventions(@PathVariable int id) {
        Invention invention = repo.findById(id).orElse(null);
        if (invention == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(invention);


    }
    @PostMapping
    public ResponseEntity<Object> createInventions(
            @Valid @RequestBody InventionDto inventionDto,
            BindingResult result) {
        double price = 0;
        try {
            price = Double.parseDouble(inventionDto.getPrice());
        }catch (Exception ex){
            result.addError(new FieldError("inventionDto", "price",
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

        Invention invention = new Invention();

        invention.setName(inventionDto.getName());
        invention.setCategory(inventionDto.getCategory());
        invention.setPrice(price);
        invention.setDescription(inventionDto.getDescription());
        invention.setCreatedAt(new Date());

        repo.save(invention);
        return ResponseEntity.ok(invention);
    }

    @PutMapping("{id}")
    public ResponseEntity<Object> updateInvention(
            @PathVariable int id,
            @Valid @RequestBody InventionDto inventionDto,
            BindingResult result
    )   {
        Invention invention = repo.findById(id).orElse(null);
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
    @DeleteMapping("{id}")
    public ResponseEntity<Object> deleteInvention(@PathVariable int id){
        Invention invention = repo.findById(id).orElse(null);
        if (invention == null){
            return ResponseEntity.notFound().build();
        }
        repo.delete(invention);
        return ResponseEntity.ok().build();

    }

}