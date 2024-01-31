package com.vehicule.api.services;

import com.vehicule.api.entity.VenteAnnonce;
import com.vehicule.api.entity.User;
import com.vehicule.api.entity.Annonce;
import com.vehicule.api.repository.VenteAnnonceRepository;
import com.vehicule.api.repository.UserRepository;
import com.vehicule.api.repository.AnnonceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.time.LocalDateTime;

@Service
public class VenteAnnonceService {
    private final VenteAnnonceRepository venteannonceRepository;

    @Autowired
    public VenteAnnonceService(VenteAnnonceRepository venteannonceRepository) {
        this.venteannonceRepository = venteannonceRepository;
    }

    public VenteAnnonce saveVenteAnnonce(User acheteur,Annonce annonce){
        VenteAnnonce venteannonce = new VenteAnnonce();
        venteannonce.setAcheteur(acheteur);
        venteannonce.setAnnonce(annonce);
        venteannonce.setDate(LocalDateTime.now());
        venteannonce = venteannonceRepository.save(venteannonce);
        return venteannonce;
    }

    public void deleteVenteAnnonce(Long id){
        venteannonceRepository.deleteById(id);
    }

    public VenteAnnonce updateVenteAnnonce(Long id, VenteAnnonce ann){
        ann.setIdVenteAnnonce(id);
        venteannonceRepository.save(ann);
        return ann;
    }

    public List<Object[]> venteByMarque() {
        return venteannonceRepository.venteByMarque();
    }
    
    public List<Object[]> venteByBoite() {
        return venteannonceRepository.venteByBoite();
    }
    
    public List<Object[]> venteByCarburant() {
        return venteannonceRepository.venteByCarburant();
    }
    
    public List<Object[]> sommeCommission() {
        return venteannonceRepository.sommeCommission();
    }
    
    public List<Object[]> venteByCategorie(Long idCategorie) {
        return venteannonceRepository.venteByCategorie(idCategorie);
    }
    
}
