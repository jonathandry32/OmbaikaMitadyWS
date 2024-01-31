package com.vehicule.api.services;

import com.vehicule.api.entity.Modele;
import com.vehicule.api.entity.Carburant;
import com.vehicule.api.entity.CarburantModele;
import com.vehicule.api.repository.CarburantModeleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class CarburantModeleService {
    private final CarburantModeleRepository carburantmodeleRepository;

    @Autowired
    public CarburantModeleService(CarburantModeleRepository carburantmodeleRepository) {
        this.carburantmodeleRepository = carburantmodeleRepository;
    }

    public CarburantModele saveCarburantModele(Modele modele,Carburant carburant){
        CarburantModele mdl = new CarburantModele();
        mdl.setModele(modele);
        mdl.setCarburant(carburant);
        mdl = carburantmodeleRepository.save(mdl);
        return mdl;
    }
    
    public List<CarburantModele> getByModele(Long modeleId) {
        return carburantmodeleRepository.findByModele_IdModele(modeleId);
    }
}
