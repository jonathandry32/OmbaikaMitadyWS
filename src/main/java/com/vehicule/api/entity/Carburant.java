package com.vehicule.api.entity;


import jakarta.persistence.*;

@Entity
@Table
public class Carburant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_carburant", nullable = false)
    private Long idCarburant;

    private String nom;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Long getIdCarburant() {
        return idCarburant;
    }

    public void setIdCarburant(Long idCarburant) {
        this.idCarburant = idCarburant;
    }
}
