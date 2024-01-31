package com.vehicule.api.repository;


import com.vehicule.api.entity.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehiculeRepository extends JpaRepository<Vehicule, Long> {
}
