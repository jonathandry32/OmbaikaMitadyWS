package com.vehicule.api.controller;

import com.vehicule.api.entity.Kilometrage;
import com.vehicule.api.entity.Vehicule;
import com.vehicule.api.repository.KilometrageRepository;
import com.vehicule.api.repository.VehiculeRepository;
import com.vehicule.api.services.KilometrageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class KilometrageController {
    private final KilometrageService kilometrageService;
    private final KilometrageRepository kilometrageRepository;
    private final VehiculeRepository vehiculeRepository;

    @Autowired
    public KilometrageController(KilometrageService kilometrageService, KilometrageRepository kilometrageRepository, VehiculeRepository vehiculeRepository){
        this.kilometrageService = kilometrageService;
        this.kilometrageRepository = kilometrageRepository;
        this.vehiculeRepository = vehiculeRepository;
    }

    @GetMapping("/kilometrages")
    public List<Kilometrage> findAll(){
        return kilometrageRepository.findAll();
    }

    @PostMapping("/kilometrage")
    public Kilometrage save(String date, double debutKm
    ,  double finKm, Long idVehicule){
        Vehicule vehicule = vehiculeRepository.findById(idVehicule).get();
        return kilometrageService.saveKm(date,debutKm,finKm,vehicule);
    }

}
