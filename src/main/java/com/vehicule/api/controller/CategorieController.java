package com.vehicule.api.controller;


import com.vehicule.api.entity.Categorie;
import com.vehicule.api.repository.CategorieRepository;
import com.vehicule.api.services.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import java.util.Collection;

@RestController
public class CategorieController {
    private final CategorieService categorieService;
    private CategorieRepository categorieRepository = null;

    @Autowired
    public CategorieController(CategorieService categorieService,
                               CategorieRepository categorieRepository) {
        this.categorieService = categorieService;
        this.categorieRepository = categorieRepository;
    }

    @GetMapping("/categories")
    public List<Categorie> findAll(){
        return categorieRepository.findAll();
    }

    @PostMapping("/categorie")
    public Categorie save(String nom){
        return categorieService.saveCategorie(nom);
    }
}
