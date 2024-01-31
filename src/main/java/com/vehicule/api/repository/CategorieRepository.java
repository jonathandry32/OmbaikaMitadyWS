package com.vehicule.api.repository;

import com.vehicule.api.entity.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepository extends JpaRepository<Categorie,Long> {
}
