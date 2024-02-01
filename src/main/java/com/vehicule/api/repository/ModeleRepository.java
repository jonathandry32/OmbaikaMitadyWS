package com.vehicule.api.repository;

import com.vehicule.api.entity.Modele;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ModeleRepository extends JpaRepository<Modele, Long> {
  List<Modele> findAllByMarqueIdMarque(int idMarque);
}
