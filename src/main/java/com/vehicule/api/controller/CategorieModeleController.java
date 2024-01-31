package com.vehicule.api.controller;


import com.vehicule.api.entity.CategorieModele;
import com.vehicule.api.entity.Categorie;
import com.vehicule.api.entity.Modele;
import com.vehicule.api.repository.ModeleRepository;
import com.vehicule.api.repository.CategorieRepository;
import com.vehicule.api.repository.CategorieModeleRepository;
import com.vehicule.api.services.CategorieModeleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
public class CategorieModeleController {

    private final CategorieModeleService categoriemodeleService;
    private final CategorieModeleRepository categoriemodeleRepository;
    private final ModeleRepository modeleRepository;
    private final CategorieRepository categorieRepository;

    public CategorieModeleController(CategorieModeleService categoriemodeleService, CategorieModeleRepository categoriemodeleRepository,
    ModeleRepository modeleRepository,CategorieRepository categorieRepository) {
        this.categoriemodeleService = categoriemodeleService;
        this.categoriemodeleRepository = categoriemodeleRepository;
        this.modeleRepository = modeleRepository;
        this.categorieRepository = categorieRepository;
    }

    @PostMapping("/categoriemodele")
    public CategorieModele save(Long idModele,Long idCategorie){
        Modele modele = modeleRepository.findById(idModele).get();
        Categorie categorie = categorieRepository.findById(idCategorie).get();
        return categoriemodeleService.saveModele(modele,categorie);
    }
    
    @GetMapping("/modele/categories/{modeleId}")
    public List<CategorieModele> getCategorieModele(@PathVariable Long modeleId) {
        return categoriemodeleService.getByModele(modeleId);
    }
    
    @GetMapping("/auth/modele/categories/{modeleId}")
    public List<CategorieModele> getCategorieModelelibre(@PathVariable Long modeleId) {
        return categoriemodeleService.getByModele(modeleId);
    }
}
