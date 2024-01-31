package com.vehicule.api.repository;


import com.vehicule.api.entity.Entretien;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntretienRepository extends JpaRepository<Entretien, Long> {
}
