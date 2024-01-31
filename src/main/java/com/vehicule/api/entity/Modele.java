package com.vehicule.api.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table
public class Modele {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_modele", nullable = false)
    private Long idModele;
    @ManyToOne
    @JoinColumn(name = "id_marque")
    Marque marque;

    private String nom;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Marque getMarque() {
        return marque;
    }

    public void setMarque(Marque marque) {
        this.marque = marque;
    }

    public Long getIdModele() {
        return idModele;
    }

    public void setIdModele(Long idModel) {
        this.idModele = idModel;
    }
    
    @OneToMany(mappedBy = "modele")
    private List<CategorieModele> categoriemodele;

}
