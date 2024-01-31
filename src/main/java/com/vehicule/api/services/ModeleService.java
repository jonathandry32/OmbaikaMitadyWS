package com.vehicule.api.services;

import com.vehicule.api.entity.Modele;
import com.vehicule.api.entity.Marque;
import com.vehicule.api.repository.ModeleRepository;
import com.vehicule.api.repository.MarqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ModeleService {
    private final ModeleRepository modeleRepository;

    @Autowired
    public ModeleService(ModeleRepository modeleRepository) {
        this.modeleRepository = modeleRepository;
    }

    public Modele saveModele(Marque marque,String nom){
        Modele mdl = new Modele();
        mdl.setMarque(marque);
        mdl.setNom(nom);
        mdl = modeleRepository.save(mdl);
        return mdl;
    }
}
