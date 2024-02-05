package com.vehicule.api.controller;

import com.vehicule.api.entity.Marque;
import com.vehicule.api.repository.MarqueRepository;
import com.vehicule.api.services.MarqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class MarqueController {
    private final MarqueService marqueService;
    private final MarqueRepository marqueRepository;
    
    @Autowired
    public MarqueController(MarqueService marqueService, MarqueRepository marqueRepository){
        this.marqueService = marqueService;
        this.marqueRepository = marqueRepository;
    }

    @GetMapping("/marques")
    public List<Marque> findAll(){
        return marqueRepository.findAll();
    }

    @GetMapping("/auth/marques")
    public List<Marque> findAllauth(){
        return marqueRepository.findAll();
    }

    @PostMapping("/marque")
    public Marque save(String nom){
        return marqueService.saveMarque(nom);
    }
}
