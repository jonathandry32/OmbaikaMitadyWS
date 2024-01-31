package com.vehicule.api.services;

import com.vehicule.api.entity.Categorie;
import com.vehicule.api.repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategorieService {
    private final CategorieRepository categorieRepository;

    @Autowired
    public CategorieService(CategorieRepository categorieRepository) {
        this.categorieRepository = categorieRepository;
    }

    public Categorie saveCategorie(String nom){
        Categorie mq = new Categorie();
        mq.setNom(nom);
        mq = categorieRepository.save(mq);
        return mq;
    }


}
