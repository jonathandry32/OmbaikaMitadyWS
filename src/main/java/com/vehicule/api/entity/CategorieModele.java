package com.vehicule.api.entity;


import jakarta.persistence.*;

@Entity
@Table
public class CategorieModele {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_categorie_modele", nullable = false)
    private Long idCategorieModele;

    @ManyToOne
    @JoinColumn(name = "id_modele")
    private Modele modele;

    @ManyToOne
    @JoinColumn(name = "id_categorie")
    private Categorie categorie;

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public Modele getModele() {
        return modele;
    }

    public void setModele(Modele modele) {
        this.modele = modele;
    }

    public Long getIdCategorieModele() {
        return idCategorieModele;
    }

    public void setIdCategorieModele(Long idCategorieModele) {
        this.idCategorieModele = idCategorieModele;
    }
}
