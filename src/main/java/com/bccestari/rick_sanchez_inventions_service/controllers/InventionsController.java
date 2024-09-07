package com.bccestari.rick_sanchez_inventions_service.controllers;

import com.bccestari.rick_sanchez_inventions_service.models.Inventions;
import com.bccestari.rick_sanchez_inventions_service.repositories.InventionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}