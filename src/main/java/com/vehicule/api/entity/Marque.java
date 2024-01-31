package com.vehicule.api.entity;


import jakarta.persistence.*;

@Entity
@Table
public class Marque {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_marque", nullable = false)
    private Long idMarque;
    private String nom;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Long getIdMarque() {
        return idMarque;
    }

    public void setIdMarque(Long idMarque) {
        this.idMarque = idMarque;
    }
}
