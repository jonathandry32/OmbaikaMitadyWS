package com.vehicule.api.controller;

import com.vehicule.api.entity.Commission;
import com.vehicule.api.repository.CommissionRepository;
import com.vehicule.api.services.CommissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class CommissionController {
    private final CommissionService commissionService;
    private final CommissionRepository commissionRepository;
    @Autowired
    public CommissionController(CommissionService commissionService, CommissionRepository commissionRepository){
        this.commissionService = commissionService;
        this.commissionRepository = commissionRepository;
    }

    @GetMapping("/commissions")
    public List<Commission> findAll(){
        return commissionRepository.findAll();
    }

    @PostMapping("/commission")
    public Commission save(double valeur){
        return commissionService.saveCommission(valeur);
    }

    @GetMapping("/commissions/{id}")
    public Optional<Commission> find(@PathVariable("id") Long id){
        return commissionRepository.findById(id);
    }

    @PutMapping("/commissions/{id}")
    public Commission modif(@PathVariable Long id, @RequestBody Commission v){
        return commissionService.updateCommission(id, v);
    }

    @DeleteMapping("/commissions/{id}")
    public void deleteById(@PathVariable Long id){
        commissionService.deleteCommission(id);
    }

    @DeleteMapping("/commissions")
    public void deleteAll(){
        commissionRepository.deleteAll();
    }
}
