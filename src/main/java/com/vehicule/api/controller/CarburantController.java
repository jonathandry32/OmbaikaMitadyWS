package com.vehicule.api.controller;


import com.vehicule.api.entity.Carburant;
import com.vehicule.api.repository.CarburantRepository;
import com.vehicule.api.services.CarburantService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@RestController
public class CarburantController {
    private final CarburantService carburantService;
    private final CarburantRepository carburantRepository;

    @Autowired
    public CarburantController(CarburantService carburantService,CarburantRepository carburantRepository) {
        this.carburantService = carburantService;
        this.carburantRepository = carburantRepository;
    }

    @GetMapping("/carburants")
    public List<Carburant> findAll(){
        return carburantRepository.findAll();
    }

    @PostMapping("/carburant")
    public Carburant save(String nom){
        return carburantService.saveCarburant(nom);
    }

}
