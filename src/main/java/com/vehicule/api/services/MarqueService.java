package com.vehicule.api.services;

import com.vehicule.api.entity.Marque;
import com.vehicule.api.repository.MarqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarqueService {
    private final MarqueRepository marqueRepository;

    @Autowired
    public MarqueService(MarqueRepository marqueRepository) {
        this.marqueRepository = marqueRepository;
    }

    public Marque saveMarque(String nom){
        Marque mq = new Marque();
        mq.setNom(nom);
        mq = marqueRepository.save(mq);
        return mq;
    }
    
}
