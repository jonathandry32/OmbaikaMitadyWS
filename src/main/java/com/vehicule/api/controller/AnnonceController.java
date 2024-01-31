package com.vehicule.api.controller;

import com.vehicule.api.dto.*;
import com.vehicule.api.entity.Annonce;
import com.vehicule.api.entity.User;
import com.vehicule.api.entity.PhotoAnnonce;
import com.vehicule.api.entity.AnnonceFavoris;
import com.vehicule.api.entity.Modele;
import com.vehicule.api.entity.Carburant;
import com.vehicule.api.repository.AnnonceRepository;
import com.vehicule.api.repository.UserRepository;
import com.vehicule.api.repository.ModeleRepository;
import com.vehicule.api.repository.CarburantRepository;
import com.vehicule.api.services.AnnonceService;
import com.vehicule.api.services.PhotoAnnonceService;
import com.vehicule.api.services.VenteAnnonceService;
import com.vehicule.api.services.AnnonceFavorisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

@RestController
public class AnnonceController {
    private final AnnonceService annonceService;
    private final AnnonceRepository annonceRepository;
    private final UserRepository userRepository;
    private final ModeleRepository modeleRepository;
    private final CarburantRepository carburantRepository;
    private final VenteAnnonceService venteannonceService;
    private final PhotoAnnonceService photoannonceService;
    private final AnnonceFavorisService annoncefavorisService;
    
    @Autowired
    public AnnonceController(AnnonceService annonceService, AnnonceRepository annonceRepository,
    UserRepository userRepository,ModeleRepository modeleRepository,CarburantRepository carburantRepository,
    VenteAnnonceService venteannonceService,PhotoAnnonceService photoannonceService,AnnonceFavorisService annoncefavorisService){
        this.annonceService = annonceService;
        this.venteannonceService = venteannonceService;
        this.annonceRepository = annonceRepository;
        this.userRepository = userRepository;
        this.modeleRepository = modeleRepository;
        this.carburantRepository = carburantRepository;
        this.photoannonceService = photoannonceService;
        this.annoncefavorisService = annoncefavorisService;
    }

    @GetMapping("/auth/annonces")
    public List<Annonce> findAll(){
        return annonceRepository.findAll();
    }

    @PostMapping("/annonce")
    public Annonce save(String description,Long idUser,Long idModele,Long idCarburant,String boite,String contact,double prix,double kilometrage){
        User proprietaire = userRepository.findById(idUser).get();
        Modele modele = modeleRepository.findById(idModele).get();
        Carburant carburant = carburantRepository.findById(idCarburant).get();
        double commission=0;
        int etat=0;
        int status=0;   
        return annonceService.saveAnnonce(description,proprietaire,modele,carburant,boite,contact,prix,commission,kilometrage,etat,status);
    }
    
    @PostMapping("/annonces")
    public Annonce saves(String description,Long idUser,Long idModele,Long idCarburant,String boite,String contact,double prix,double kilometrage,List<String> photos){
        User proprietaire = userRepository.findById(idUser).get();
        Modele modele = modeleRepository.findById(idModele).get();
        Carburant carburant = carburantRepository.findById(idCarburant).get();
        double commission=0;
        int etat=0;
        int status=0;   
        Annonce result = annonceService.saveAnnonce(description,proprietaire,modele,carburant,boite,contact,prix,commission,kilometrage,etat,status);
        for(int i=0;i<photos.size();i++){
            photoannonceService.savePhotoAnnonce(result, photos.get(i));
        }
        return result;
    }

    @GetMapping("/auth/annonces/{id}")
    public Optional<Annonce> find(@PathVariable("id") Long id){
        return annonceRepository.findById(id);
    }

    @GetMapping("/auth/annonces/details/{id}")
    public AnnonceDTO getAnnonceUsers(@PathVariable("id") Long id,Long idUser) {
        Annonce annonceTemp = annonceRepository.findById(id).get();
        List<PhotoAnnonce> listPhotos = photoannonceService.getPhotosByAnnonceId(annonceTemp.getIdAnnonce());
        AnnonceDTO result = new AnnonceDTO(annonceTemp,listPhotos,annoncefavorisService.estAnnonceFavoris(idUser, annonceTemp.getIdAnnonce()));
        return result;
    }

    @PutMapping("/annonces/{id}")
    public Annonce modif(@PathVariable Long id, @RequestBody Annonce v){
        return annonceService.updateAnnonce(id, v);
    }

    @DeleteMapping("/annonces/{id}")
    public void deleteById(@PathVariable Long id){
        annonceService.deleteAnnonce(id);
    }

    @DeleteMapping("/annonces")
    public void deleteAll(){
        annonceRepository.deleteAll();
    }

    @GetMapping("/annonces/user/{userId}")
    public List<Annonce> getAnnoncesByUserId(@PathVariable Long userId) {
        return annonceService.getAnnoncesByUserId(userId);
    }
    
    @GetMapping("/annonces/users/{userId}")
    public List<AnnonceDTO> getAnnonceUsers(@PathVariable Long userId) {
        List<AnnonceDTO> result = new ArrayList<AnnonceDTO>();
        List<Annonce> listAnnonceTemp = annonceService.getAnnoncesByUserId(userId);
        for(int i=0;i<listAnnonceTemp.size();i++){
            List<PhotoAnnonce> listPhotos = photoannonceService.getPhotosByAnnonceId(listAnnonceTemp.get(i).getIdAnnonce());
            AnnonceDTO temp = new AnnonceDTO(listAnnonceTemp.get(i),listPhotos,annoncefavorisService.estAnnonceFavoris(userId, listAnnonceTemp.get(i).getIdAnnonce()));
            result.add(temp);
        }
        return result;
    }
    
    @PutMapping("/annonces/sell")
    public void updateStatusByIdAnnonce(Long idAnnonce,Long idUser) {
        annonceService.updateStatusByIdAnnonce(idAnnonce);
        User acheteur = userRepository.findById(idUser).get();
        Annonce annonce = annonceRepository.findById(idAnnonce).get();
        venteannonceService.saveVenteAnnonce(acheteur,annonce);
    }

    @PutMapping("/annonces/validate")
    public void updateEtatByIdAnnonce(Long idAnnonce,double commission) {
        annonceService.updateEtatByIdAnnonce(idAnnonce,commission);
    }

    @GetMapping("/auth/annonces/encours")
    public List<Annonce> getAnnouncementsByEtatAndStatus() {
        int etat = 10;
        int status = 0;
        return annonceService.getAnnouncementsByEtatAndStatus(etat, status);
    }
    
    @GetMapping("/auth/annonces/envente")
    public List<AnnonceDTO> getAnnonceEnCours(Long idUser) {
        List<AnnonceDTO> result = new ArrayList<AnnonceDTO>();
        List<Annonce> listAnnonceTemp = annonceService.getAnnouncementsByEtatAndStatus(10, 0);
        for(int i=0;i<listAnnonceTemp.size();i++){
            List<PhotoAnnonce> listPhotos = photoannonceService.getPhotosByAnnonceId(listAnnonceTemp.get(i).getIdAnnonce());
            AnnonceDTO temp = new AnnonceDTO(listAnnonceTemp.get(i),listPhotos,annoncefavorisService.estAnnonceFavoris(idUser, listAnnonceTemp.get(i).getIdAnnonce()));
            result.add(temp);
        }
        return result;
    }
    
    @GetMapping("/annonces/vendus")
    public List<Annonce> getAnnonceVendu() {
        int etat = 10;
        int status = 10;
        return annonceService.getAnnouncementsByEtatAndStatus(etat, status);
    }

    @GetMapping("/annonces/vendusall")
    public List<AnnonceDTO> getAnnonceVendusAll(Long idUser) {
        List<AnnonceDTO> result = new ArrayList<AnnonceDTO>();
        List<Annonce> listAnnonceTemp = annonceService.getAnnouncementsByEtatAndStatus(10, 10);
        for(int i=0;i<listAnnonceTemp.size();i++){
            List<PhotoAnnonce> listPhotos = photoannonceService.getPhotosByAnnonceId(listAnnonceTemp.get(i).getIdAnnonce());
            AnnonceDTO temp = new AnnonceDTO(listAnnonceTemp.get(i),listPhotos,annoncefavorisService.estAnnonceFavoris(idUser, listAnnonceTemp.get(i).getIdAnnonce()));
            result.add(temp);
        }
        return result;
    }
    
    @GetMapping("/annonces/nonvalide")
    public List<Annonce> getAnnonceNonValide() {
        int etat = 0;
        int status = 0;
        return annonceService.getAnnouncementsByEtatAndStatus(etat, status);
    }
}
