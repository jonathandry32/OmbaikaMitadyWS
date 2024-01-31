package com.vehicule.api.controller;

import com.vehicule.api.entity.Vehicule;
import com.vehicule.api.repository.VehiculeRepository;
import com.vehicule.api.services.VehiculeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class VehiculeController {
    private final VehiculeService vehiculeService;
    private final VehiculeRepository vehiculeRepository;
    
    @Autowired
    public VehiculeController(VehiculeService vehiculeService, VehiculeRepository vehiculeRepository){
        this.vehiculeService = vehiculeService;
        this.vehiculeRepository = vehiculeRepository;
    }

    @GetMapping("/vehicules")
    public List<Vehicule> findAll(){
        return vehiculeRepository.findAll();
    }

    @PostMapping("/vehicule")
    public Vehicule save(String marque,String matricule){
        return vehiculeService.saveCar(marque, matricule);
    }

    @GetMapping("/vehicules/{id}")
    public Optional<Vehicule> find(@PathVariable("id") Long id){
        return vehiculeRepository.findById(id);
    }

    @PutMapping("/vehicules/{id}")
    public Vehicule modif(@PathVariable Long id, @RequestBody Vehicule v){
        return vehiculeService.updateCar(id, v);
    }

    @DeleteMapping("/vehicules/{id}")
    public void deleteById(@PathVariable Long id){
        vehiculeService.deleteCar(id);
    }

    @DeleteMapping("/vehicules")
    public void deleteAll(){
        vehiculeRepository.deleteAll();
    }
}
