package com.vehicule.api.services;


import com.vehicule.api.entity.Carburant;
import com.vehicule.api.repository.CarburantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarburantService {
    private final CarburantRepository carburantRepository;

    @Autowired
    public CarburantService(CarburantRepository carburantRepository) {
        this.carburantRepository = carburantRepository;
    }

    public Carburant saveCarburant(String nom){
        Carburant mq = new Carburant();
        mq.setNom(nom);
        mq = carburantRepository.save(mq);
        return mq;
    }
}
