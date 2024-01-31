package com.vehicule.api.entity;


import jakarta.persistence.*;


@Entity
@Table
public class CarburantModele {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_carburant_modele", nullable = false)
    private Long idCarburantModele;

    @ManyToOne
    @JoinColumn(name = "id_modele")
    Modele modele;


    @ManyToOne
    @JoinColumn(name = "id_carburant")
    Carburant carburant;

    public Carburant getCarburant() {
        return carburant;
    }

    public void setCarburant(Carburant carburant) {
        this.carburant = carburant;
    }

    public Modele getModele() {
        return modele;
    }

    public void setModele(Modele modele) {
        this.modele = modele;
    }

    public Long getIdCarburantModele() {
        return idCarburantModele;
    }

    public void setIdCarburantModele(Long idCarburantModele) {
        this.idCarburantModele = idCarburantModele;
    }
}
