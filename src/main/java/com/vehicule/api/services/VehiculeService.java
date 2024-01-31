package com.vehicule.api.services;

import com.vehicule.api.entity.Vehicule;
import com.vehicule.api.repository.VehiculeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehiculeService {
    private final VehiculeRepository vehiculeRepository;

    @Autowired
    public VehiculeService(VehiculeRepository vehiculeRepository) {
        this.vehiculeRepository = vehiculeRepository;
    }

    public Vehicule saveCar(String marque, String plaque){
        Vehicule vehicule = new Vehicule();
        vehicule.setMarque(marque);
        vehicule.setMatricule(plaque);
        vehicule = vehiculeRepository.save(vehicule);
        return vehicule;
    }

    public void deleteCar(Long id){
        vehiculeRepository.deleteById(id);
    }

    public Vehicule updateCar(Long id, Vehicule v){
        v.setId(id);
        vehiculeRepository.save(v);
        return v;
    }
}
