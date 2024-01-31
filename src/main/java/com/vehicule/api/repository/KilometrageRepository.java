package com.vehicule.api.repository;


import com.vehicule.api.entity.Kilometrage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KilometrageRepository extends JpaRepository<Kilometrage, Long> {
}
