package com.vehicule.api.repository;

import com.vehicule.api.entity.VenteAnnonce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.Modifying;

public interface VenteAnnonceRepository extends JpaRepository<VenteAnnonce, Long> {
    @Query("SELECT M.marque.nom AS Marque, COUNT(VA.idVenteAnnonce) AS NombreVenteMarque " +
           "FROM VenteAnnonce VA " +
           "JOIN VA.annonce A " +
           "JOIN A.modele M " +
           "WHERE VA.etat=10"+
           "GROUP BY M.marque.nom " +
           "ORDER BY NombreVenteMarque")
    List<Object[]> venteByMarque();
    
    @Query("SELECT c.categorie.nom, COUNT(*) as nombreVenteCategorie FROM VenteAnnonce va " +
           "JOIN va.annonce.modele.categoriemodele c " +
           "WHERE c.categorie.idCategorie = :idCategorie " +
           "AND va.etat=10 "+
           "GROUP BY c.categorie.nom")
    List<Object[]> venteByCategorie(Long idCategorie);

    @Query("SELECT A.boite AS Boite, COUNT(VA.idVenteAnnonce) AS NombreVenteBoite " +
           "FROM VenteAnnonce VA " +
           "JOIN VA.annonce A " +
           "WHERE VA.etat=10"+
           "GROUP BY A.boite " +
           "ORDER BY NombreVenteBoite")
    List<Object[]> venteByBoite();

    @Query("SELECT C.nom AS Carburant, COUNT(VA.idVenteAnnonce) AS NombreVenteCarburant " +
           "FROM VenteAnnonce VA " +
           "JOIN VA.annonce A " +
           "JOIN A.carburant C " +
           "WHERE VA.etat=10"+
           "GROUP BY C.nom " +
           "ORDER BY NombreVenteCarburant")
    List<Object[]> venteByCarburant();

    @Query("SELECT " +
           "SUM(VA.annonce.commission * VA.annonce.prix/100) AS SumCommissionPrix " +
           "FROM VenteAnnonce VA "+
           "WHERE VA.etat=10")
    List<Object[]> sommeCommission();

    @Query("SELECT va FROM VenteAnnonce va WHERE va.etat = 0 AND va.annonce.proprietaire.id = :idUser")
    List<VenteAnnonce> getDemandeAchatByUser(Long idUser);

    @Transactional
    @Modifying
    @Query("UPDATE VenteAnnonce va SET va.etat = 10 WHERE va.idVenteAnnonce = :idVenteAnnonce")
    void validerAchat(Long idVenteAnnonce);

    @Transactional
    @Modifying
    @Query("DELETE FROM VenteAnnonce va WHERE va.annonce.idAnnonce = :idAnnonce AND va.acheteur.id != :idUser")
    void deleteByIdAnnonceAndNotIdUser(Long idAnnonce, Long idUser);

       @Transactional
       @Modifying
       @Query("DELETE FROM VenteAnnonce va WHERE va.idVenteAnnonce = :idVenteAnnonce")
       void deleteByIdVenteAnnonce(Long idVenteAnnonce);
    
    boolean existsByAnnonceIdAnnonceAndAcheteurId(Long idAnnonce, Long idUser);
}
