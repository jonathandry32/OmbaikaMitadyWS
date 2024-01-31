package com.vehicule.api.repository;

import com.vehicule.api.entity.CategorieModele;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CategorieModeleRepository extends JpaRepository<CategorieModele,Long> {
    List<CategorieModele> findByModele_IdModele(Long modeleId);
}
