package com.vehicule.api.controller;

import com.vehicule.api.entity.TypeEntretien;
import com.vehicule.api.repository.TypeEntretienRepository;
import com.vehicule.api.services.TypeEntretienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class TypeEntretienController {
    private final TypeEntretienService typeEntretienService;
    private final TypeEntretienRepository typeEntretienRepository;
    @Autowired
    public TypeEntretienController(TypeEntretienService typeEntretienService, TypeEntretienRepository typeEntretienRepository){
        this.typeEntretienService = typeEntretienService;
        this.typeEntretienRepository = typeEntretienRepository;
    }

    @GetMapping("/typeEntretiens")
    public List<TypeEntretien> findAll(){
        return typeEntretienRepository.findAll();
    }

    @PostMapping("/typeEntretien")
    public TypeEntretien save(@RequestParam(value = "nom") String nom){
        return typeEntretienService.saveTypeEntretien(nom);
    }

    @GetMapping("/typeEntretiens/{id}")
    public Optional<TypeEntretien> find(@PathVariable("id") Long id){
        return typeEntretienRepository.findById(id);
    }
}
