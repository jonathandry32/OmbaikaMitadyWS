package com.vehicule.api.services;

import com.vehicule.api.entity.Entretien;
import com.vehicule.api.entity.TypeEntretien;
import com.vehicule.api.entity.Vehicule;
import com.vehicule.api.repository.EntretienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;

@Service
public class EntretienService {
    private final EntretienRepository entretienRepository;

    @Autowired
    public EntretienService(EntretienRepository entretienRepository) {
        this.entretienRepository = entretienRepository;
    }

    public Entretien saveEntretien(String date, String remarque,Vehicule vehicule,TypeEntretien typeEntretien){
        Entretien entretien = new Entretien();
        entretien.setDate(new Date(date));
        entretien.setRemarque(remarque);
        entretien.setVehicule(vehicule);
        entretien.setTypeEntretien(typeEntretien);
        entretien = entretienRepository.save(entretien);
        return entretien;
    }

    public void deleteEntretien(Long id){
        entretienRepository.deleteById(id);
    }

    public Entretien updateEntretien(Long id, Entretien v){
        v.setId(id);
        entretienRepository.save(v);
        return v;
    }
}
