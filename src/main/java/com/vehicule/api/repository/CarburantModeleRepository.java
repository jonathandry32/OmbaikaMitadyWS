package com.vehicule.api.repository;

import com.vehicule.api.entity.CarburantModele;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CarburantModeleRepository extends JpaRepository<CarburantModele,Long> {
    List<CarburantModele> findByModele_IdModele(Long modeleId);
}
