package com.vehicule.api.repository;


import com.vehicule.api.entity.Annonce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface AnnonceRepository extends JpaRepository<Annonce, Long> {
    List<Annonce> findByProprietaire_IdOrderByDateDesc(Long idUser);

    @Transactional
    @Modifying
    @Query("UPDATE Annonce a SET a.status = 10 WHERE a.idAnnonce = :idAnnonce")
    void vendre(Long idAnnonce);
    
    @Transactional
    @Modifying
    @Query("UPDATE Annonce a SET a.etat = 10, a.commission = :commission WHERE a.idAnnonce = :idAnnonce")
    void valider(Long idAnnonce,double commission);

    List<Annonce> findByEtatAndStatus(int etat, int status, Sort sort);

}
