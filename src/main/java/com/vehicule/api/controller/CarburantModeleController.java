package com.vehicule.api.controller;


import com.vehicule.api.entity.CarburantModele;
import com.vehicule.api.entity.Carburant;
import com.vehicule.api.entity.Modele;
import com.vehicule.api.repository.ModeleRepository;
import com.vehicule.api.repository.CarburantRepository;
import com.vehicule.api.repository.CarburantModeleRepository;
import com.vehicule.api.services.CarburantModeleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
public class CarburantModeleController {

    private final CarburantModeleService carburantmodeleService;
    private final CarburantModeleRepository carburantmodeleRepository;
    private final ModeleRepository modeleRepository;
    private final CarburantRepository carburantRepository;

    public CarburantModeleController(CarburantModeleService carburantmodeleService, CarburantModeleRepository carburantmodeleRepository,
    ModeleRepository modeleRepository,CarburantRepository carburantRepository) {
        this.carburantmodeleService = carburantmodeleService;
        this.carburantmodeleRepository = carburantmodeleRepository;
        this.modeleRepository = modeleRepository;
        this.carburantRepository = carburantRepository;
    }

    @PostMapping("/carburantmodele")
    public CarburantModele save(Long idModele,Long idCarburant){
        Modele modele = modeleRepository.findById(idModele).get();
        Carburant carburant = carburantRepository.findById(idCarburant).get();
        return carburantmodeleService.saveCarburantModele(modele,carburant);
    }
    
    @GetMapping("/modele/carburants/{modeleId}")
    public List<CarburantModele> getCarburantModele(@PathVariable Long modeleId) {
        return carburantmodeleService.getByModele(modeleId);
    }
}
