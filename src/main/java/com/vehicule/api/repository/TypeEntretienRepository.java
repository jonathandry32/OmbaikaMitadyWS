package com.vehicule.api.repository;


import com.vehicule.api.entity.TypeEntretien;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeEntretienRepository extends JpaRepository<TypeEntretien, Long> {
}
