package com.vehicule.api.repository;

import com.vehicule.api.entity.Marque;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarqueRepository extends JpaRepository<Marque,Long> {
}
