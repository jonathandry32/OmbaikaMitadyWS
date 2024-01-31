package com.vehicule.api.repository;


import com.vehicule.api.entity.Commission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommissionRepository extends JpaRepository<Commission, Long> {
}
