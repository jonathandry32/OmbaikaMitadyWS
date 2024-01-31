package com.vehicule.api.entity;


import jakarta.persistence.*;

@Entity
@Table
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idCategorie", nullable = false)
    private Long idCategorie;
    private String nom;

    public Categorie() {

    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Long getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(Long idCategorie) {
        this.idCategorie = idCategorie;
    }

    public Categorie(String nom) {
        this.nom = nom;
    }
}
