package com.vehicule.api.controller;

import com.vehicule.api.entity.Entretien;
import com.vehicule.api.entity.Vehicule;
import com.vehicule.api.entity.TypeEntretien;
import com.vehicule.api.repository.EntretienRepository;
import com.vehicule.api.repository.TypeEntretienRepository;
import com.vehicule.api.repository.VehiculeRepository;
import com.vehicule.api.services.EntretienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class EntretienController {
    private final EntretienService entretienService;
    private final EntretienRepository entretienRepository;
    private final TypeEntretienRepository typeEntretienRepository;
    private final VehiculeRepository vehiculeRepository;
    @Autowired
    public EntretienController(EntretienService entretienService, EntretienRepository entretienRepository,
    TypeEntretienRepository typeEntretienRepository,VehiculeRepository vehiculeRepository){
        this.entretienService = entretienService;
        this.entretienRepository = entretienRepository;
        this.typeEntretienRepository = typeEntretienRepository;
        this.vehiculeRepository = vehiculeRepository;
    }

    @GetMapping("/entretiens")
    public List<Entretien> findAll(){
        return entretienRepository.findAll();
    }

    @PostMapping("/entretien")
    public Entretien save(String date,String remarque,Long idVehicule,Long idTypeEntretien){
        Vehicule vehicule = vehiculeRepository.findById(idVehicule).get();
        TypeEntretien typeEntretien = typeEntretienRepository.findById(idTypeEntretien).get();
        return entretienService.saveEntretien(date, remarque,vehicule,typeEntretien);
    }

    @GetMapping("/entretiens/{id}")
    public Optional<Entretien> find(@PathVariable("id") Long id){
        return entretienRepository.findById(id);
    }

    @PutMapping("/entretiens/{id}")
    public Entretien modif(@PathVariable Long id, @RequestBody Entretien v){
        return entretienService.updateEntretien(id, v);
    }

    @DeleteMapping("/entretiens/{id}")
    public void deleteById(@PathVariable Long id){
        entretienService.deleteEntretien(id);
    }

    @DeleteMapping("/entretiens")
    public void deleteAll(){
        entretienRepository.deleteAll();
    }
}
