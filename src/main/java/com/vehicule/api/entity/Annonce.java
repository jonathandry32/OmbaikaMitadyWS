package com.vehicule.api.entity;

import jakarta.persistence.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
@Entity
@Table
public class Annonce {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idAnnonce;
    private String description;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="proprietaire",referencedColumnName="id")
    private User proprietaire;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_modele",referencedColumnName="id_modele")
    private Modele modele;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_carburant",referencedColumnName="id_carburant")
    private Carburant carburant;
    private String boite;
    private String contact;
    private LocalDateTime date;
    private double prix;
    private double commission;
    private double kilometrage;
    private int etat;
    private int status;

    public Long getIdAnnonce() {
        return idAnnonce;
    }

    public void setIdAnnonce(Long id) {
        this.idAnnonce = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getBoite() {
        return boite;
    }

    public void setBoite(String boite) {
        this.boite = boite;
    }
    
    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        if(prix>0){
            this.prix = prix;
        }
    }

    public double getCommission() {
        return commission;
    }

    public void setCommission(double commission) {
        if(commission>0){
            this.commission = commission;
        }
    }

    public double getKilometrage() {
        return kilometrage;
    }

    public void setKilometrage(double kilometrage) {
        if(kilometrage>0){
            this.kilometrage = kilometrage;
        }
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    public User getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(User propio) {
        this.proprietaire = propio;
    }
    
    public Modele getModele() {
        return modele;
    }

    public void setModele(Modele model) {
        this.modele = model;
    }

    public Carburant getCarburant() {
        return carburant;
    }

    public void setCarburant(Carburant carburant) {
        this.carburant = carburant;
    }
}
