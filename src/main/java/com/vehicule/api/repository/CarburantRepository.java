package com.vehicule.api.repository;

import com.vehicule.api.entity.Carburant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarburantRepository extends JpaRepository<Carburant,Long> {
}
