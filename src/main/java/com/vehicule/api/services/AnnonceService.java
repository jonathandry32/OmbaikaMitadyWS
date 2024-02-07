package com.vehicule.api.services;

import com.vehicule.api.entity.Annonce;
import com.vehicule.api.entity.User;
import com.vehicule.api.entity.Modele;
import com.vehicule.api.entity.Carburant;
import com.vehicule.api.repository.AnnonceRepository;
import com.vehicule.api.repository.CarburantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Sort;

import java.util.Date;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class AnnonceService {
    private final AnnonceRepository annonceRepository;

    @Autowired
    public AnnonceService(AnnonceRepository annonceRepository) {
        this.annonceRepository = annonceRepository;
    }

    public Annonce saveAnnonce(String description,User proprietaire,Modele modele,Carburant carburant,String boite,String contact,double prix,double commission,double kilometrage,int etat,int status){
        Annonce annonce = new Annonce();
        annonce.setDescription(description);
        annonce.setProprietaire(proprietaire);
        annonce.setModele(modele);
        annonce.setCarburant(carburant);
        annonce.setBoite(boite);
        annonce.setContact(contact);
        annonce.setDate(LocalDateTime.now());
        annonce.setPrix(prix);
        annonce.setCommission(commission);
        annonce.setKilometrage(kilometrage);
        annonce.setEtat(etat);
        annonce.setStatus(status);
        annonce = annonceRepository.save(annonce);
        return annonce;
    }

    public void deleteAnnonce(Long id){
        annonceRepository.deleteById(id);
    }

    public Annonce updateAnnonce(Long id, Annonce ann){
        ann.setIdAnnonce(id);
        annonceRepository.save(ann);
        return ann;
    }

    public List<Annonce> getAnnoncesByUserId(Long userId) {
        return annonceRepository.findByProprietaire_IdOrderByDateDesc(userId);
    }

    public void updateStatusByIdAnnonce(Long idAnnonce) {
        annonceRepository.vendre(idAnnonce);
    }
    
    public void updateEtatByIdAnnonce(Long idAnnonce,double commission) {
        annonceRepository.valider(idAnnonce,commission);
    }

    public List<Annonce> getAnnouncementsByEtatAndStatus(int etat, int status) {
        Sort sort = Sort.by(Sort.Direction.DESC, "date");
        return annonceRepository.findByEtatAndStatus(etat, status,sort);
    }
}
