package com.vehicule.api.entity;

import jakarta.persistence.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
@Entity
@Table
public class VenteAnnonce {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idVenteAnnonce;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="acheteur",referencedColumnName="id")
    private User acheteur;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="idAnnonce",referencedColumnName="idAnnonce")
    private Annonce annonce;
    private LocalDateTime date;
    private int etat;

    public Long getIdVenteAnnonce() {
        return idVenteAnnonce;
    }

    public void setIdVenteAnnonce(Long id) {
        this.idVenteAnnonce = id;
    }
    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public User getAcheteur() {
        return acheteur;
    }

    public void setAcheteur(User acht) {
        this.acheteur = acht;
    }
    
    public Annonce getAnnonce() {
        return annonce;
    }

    public void setAnnonce(Annonce annonce) {
        this.annonce = annonce;
    }
}
