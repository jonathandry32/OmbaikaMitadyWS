package com.vehicule.api.services;

import com.vehicule.api.entity.Kilometrage;
import com.vehicule.api.entity.Vehicule;
import com.vehicule.api.repository.KilometrageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;

@Service
public class KilometrageService {
    private final KilometrageRepository kilometrageRepository;

    @Autowired
    public KilometrageService(KilometrageRepository kilometrageRepository) {
        this.kilometrageRepository = kilometrageRepository;
    }

    public Kilometrage saveKm(String date,double debutKm,double finKm,Vehicule vehicule){
        Kilometrage kilometrage = new Kilometrage();
        kilometrage.setDate(new Date(date));
        kilometrage.setDebutKm(debutKm);
        kilometrage.setFinKm(finKm);
        kilometrage.setVehicule(vehicule);
        kilometrage = kilometrageRepository.save(kilometrage);
        return kilometrage;
    }
}
