package com.vehicule.api.services;

import com.vehicule.api.entity.TypeEntretien;
import com.vehicule.api.repository.TypeEntretienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeEntretienService {
    private final TypeEntretienRepository typeEntretienRepository;

    @Autowired
    public TypeEntretienService(TypeEntretienRepository typeEntretienRepository) {
        this.typeEntretienRepository = typeEntretienRepository;
    }

    public TypeEntretien saveTypeEntretien(String nom){
        TypeEntretien typeEntretien = new TypeEntretien();
        typeEntretien.setNom(nom);
        typeEntretien = typeEntretienRepository.save(typeEntretien);
        return typeEntretien;
    }
}
