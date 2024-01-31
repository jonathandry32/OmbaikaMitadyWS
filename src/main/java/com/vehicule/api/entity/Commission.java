package com.vehicule.api.entity;

import jakarta.persistence.*;

@Entity
@Table
public class Commission {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idCommission;
    private double valeur;

    public Long getIdCommission() {
        return idCommission;
    }

    public void setIdCommission(Long id) {
        this.idCommission = id;
    }

    public double getValeur() {
        return valeur;
    }

    public void setValeur(double valeur) {
        this.valeur = valeur;
    }
}
