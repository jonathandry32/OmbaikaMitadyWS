package com.vehicule.api.controller;

import com.vehicule.api.entity.Modele;
import com.vehicule.api.entity.Marque;
import com.vehicule.api.entity.Carburant;
import com.vehicule.api.entity.CarburantModele;
import com.vehicule.api.entity.Categorie;
import com.vehicule.api.entity.CategorieModele;
import com.vehicule.api.repository.ModeleRepository;
import com.vehicule.api.repository.MarqueRepository;
import com.vehicule.api.repository.CarburantRepository;
import com.vehicule.api.repository.CategorieRepository;
import com.vehicule.api.services.CarburantModeleService;
import com.vehicule.api.services.CategorieModeleService;
import com.vehicule.api.services.ModeleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class ModeleController {
    private final ModeleService modeleService;
    private final ModeleRepository modeleRepository;
    private final MarqueRepository marqueRepository;
    private final CarburantRepository carburantRepository;
    private final CategorieRepository categorieRepository;
    private final CarburantModeleService carburantmodeleService;
    private final CategorieModeleService categoriemodeleService;
    
    @Autowired
    public ModeleController(ModeleService modeleService,ModeleRepository modeleRepository, MarqueRepository marqueRepository
    , CarburantRepository carburantRepository, CategorieRepository categorieRepository
    , CarburantModeleService carburantmodeleService, CategorieModeleService categoriemodeleService){
        this.modeleService = modeleService;
        this.modeleRepository = modeleRepository;
        this.marqueRepository = marqueRepository;
        this.carburantRepository = carburantRepository;
        this.categorieRepository = categorieRepository;
        this.carburantmodeleService = carburantmodeleService;
        this.categoriemodeleService = categoriemodeleService;
    }

    @GetMapping("/modeles")
    public List<Modele> findAll(){
        return modeleRepository.findAll();
    }

    @GetMapping("/auth/modeles")
    public List<Modele> findAllauth(){
        return modeleRepository.findAll();
    }

    @PostMapping("/modele")
    public Modele save(Long idMarque,String nom){
        Marque marque = marqueRepository.findById(idMarque).get();
        return modeleService.saveModele(marque,nom);
    }
    
    @GetMapping("/modeles/{idMarque}")
    public List<Modele> findAllByIdMarque(@PathVariable int idMarque){
        return modeleRepository.findAllByMarqueIdMarque(idMarque);
    }
    
    @GetMapping("/auth/modeles/{idMarque}")
    public List<Modele> findAllByIdMarqueauth(@PathVariable int idMarque){
        return modeleRepository.findAllByMarqueIdMarque(idMarque);
    }
    
    @PostMapping("/modeles")
    public void saves(Long idMarque,String nom,Long[] idCategories,Long[] idCarburants){
        Marque marque = marqueRepository.findById(idMarque).get();
        Modele result = modeleService.saveModele(marque,nom);
        for(int i=0;i<idCategories.length;i++){
            Categorie categorie = categorieRepository.findById(idCategories[i]).get();
            categoriemodeleService.saveModele(result,categorie);            
        }
        for(int y=0;y<idCarburants.length;y++){
            Carburant carburant = carburantRepository.findById(idCarburants[y]).get();
            carburantmodeleService.saveCarburantModele(result,carburant);            
        }
    }
    
}
