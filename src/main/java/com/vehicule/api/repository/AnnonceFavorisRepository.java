package com.vehicule.api.repository;

import com.vehicule.api.entity.AnnonceFavoris;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AnnonceFavorisRepository extends JpaRepository<AnnonceFavoris, Long> {
    List<AnnonceFavoris> findByUser_IdOrderByAnnonce_DateDesc(Long userId);

    @Transactional
    @Modifying
    @Query("DELETE FROM AnnonceFavoris af WHERE af.annonce.idAnnonce = :idAnnonce AND af.user.id = :users")
    void supprimerFavori(Long idAnnonce, Long users);

    @Query("SELECT af FROM AnnonceFavoris af WHERE af.user.id = :userId AND af.annonce.idAnnonce = :annonceId")
    AnnonceFavoris findByUserIdAndAnnonceId(Long userId,Long annonceId);
}
