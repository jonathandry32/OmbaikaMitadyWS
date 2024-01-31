package com.vehicule.api.services;

import com.vehicule.api.entity.Modele;
import com.vehicule.api.entity.Categorie;
import com.vehicule.api.entity.CategorieModele;
import com.vehicule.api.repository.CategorieModeleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class CategorieModeleService {
    private final CategorieModeleRepository categoriemodeleRepository;

    @Autowired
    public CategorieModeleService(CategorieModeleRepository categoriemodeleRepository) {
        this.categoriemodeleRepository = categoriemodeleRepository;
    }

    public CategorieModele saveModele(Modele modele,Categorie categorie){
        CategorieModele mdl = new CategorieModele();
        mdl.setModele(modele);
        mdl.setCategorie(categorie);
        mdl = categoriemodeleRepository.save(mdl);
        return mdl;
    }
    
    public List<CategorieModele> getByModele(Long modeleId) {
        return categoriemodeleRepository.findByModele_IdModele(modeleId);
    }
}
