package com.vehicule.api.repository;

import com.vehicule.api.entity.VenteAnnonce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;

public interface VenteAnnonceRepository extends JpaRepository<VenteAnnonce, Long> {
    @Query("SELECT M.marque.nom AS Marque, COUNT(VA.idVenteAnnonce) AS NombreVenteMarque " +
           "FROM VenteAnnonce VA " +
           "JOIN VA.annonce A " +
           "JOIN A.modele M " +
           "GROUP BY M.marque.nom " +
           "ORDER BY NombreVenteMarque")
    List<Object[]> venteByMarque();
    
    @Query("SELECT c.categorie.nom, COUNT(*) as nombreVenteCategorie FROM VenteAnnonce va " +
           "JOIN va.annonce.modele.categoriemodele c " +
           "WHERE c.categorie.idCategorie = :idCategorie " +
           "GROUP BY c.categorie.nom")
    List<Object[]> venteByCategorie(Long idCategorie);

    @Query("SELECT A.boite AS Boite, COUNT(VA.idVenteAnnonce) AS NombreVenteBoite " +
           "FROM VenteAnnonce VA " +
           "JOIN VA.annonce A " +
           "GROUP BY A.boite " +
           "ORDER BY NombreVenteBoite")
    List<Object[]> venteByBoite();

    @Query("SELECT C.nom AS Carburant, COUNT(VA.idVenteAnnonce) AS NombreVenteCarburant " +
           "FROM VenteAnnonce VA " +
           "JOIN VA.annonce A " +
           "JOIN A.carburant C " +
           "GROUP BY C.nom " +
           "ORDER BY NombreVenteCarburant")
    List<Object[]> venteByCarburant();

    @Query("SELECT " +
           "SUM(VA.annonce.commission * VA.annonce.prix/100) AS SumCommissionPrix " +
           "FROM VenteAnnonce VA ")
    List<Object[]> sommeCommission();
}
