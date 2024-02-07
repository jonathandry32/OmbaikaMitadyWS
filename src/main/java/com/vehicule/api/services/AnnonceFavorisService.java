package com.vehicule.api.services;

import com.vehicule.api.entity.AnnonceFavoris;
import com.vehicule.api.entity.User;
import com.vehicule.api.entity.Annonce;
import com.vehicule.api.repository.AnnonceFavorisRepository;
import com.vehicule.api.repository.UserRepository;
import com.vehicule.api.repository.AnnonceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

@Service
public class AnnonceFavorisService {
    private final AnnonceFavorisRepository annonceFavorisRepository;

    @Autowired
    public AnnonceFavorisService(AnnonceFavorisRepository annonceFavorisRepository) {
        this.annonceFavorisRepository = annonceFavorisRepository;
    }

    public AnnonceFavoris saveAnnonceFavoris(User user,Annonce annonce){
        AnnonceFavoris annonceFavoris = new AnnonceFavoris();
        annonceFavoris.setUser(user);
        annonceFavoris.setAnnonce(annonce);
        annonceFavoris = annonceFavorisRepository.save(annonceFavoris);
        return annonceFavoris;
    }

    public void deleteAnnonceFavoris(Long id){
        annonceFavorisRepository.deleteById(id);
    }

    public AnnonceFavoris updateAnnonceFavoris(Long id, AnnonceFavoris ann){
        ann.setIdAnnonceFavoris(id);
        annonceFavorisRepository.save(ann);
        return ann;
    }
    
    public List<AnnonceFavoris> getFavoriteAnnoncesByUserId(Long userId) {
        return annonceFavorisRepository.findByUser_IdOrderByAnnonce_DateDesc(userId);
    }
    
    public boolean estAnnonceFavoris(Long idUser, Long idAnnonce) {
        AnnonceFavoris annonceFavoris = annonceFavorisRepository.findByUserIdAndAnnonceId(idUser, idAnnonce);
        return annonceFavoris != null;
    }

    public void supprimerFavori(Long idAnnonce, Long idUser) {
        annonceFavorisRepository.supprimerFavori(idAnnonce, idUser);
    }
}
