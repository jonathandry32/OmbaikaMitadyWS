package com.vehicule.api.entity;

import jakarta.persistence.*;
import java.util.Date;
import java.text.SimpleDateFormat;
@Entity
@Table
public class Kilometrage {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private Date date;
    private double debutKm;
    private double finKm;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_vehicule",referencedColumnName="id")
    private Vehicule vehicule;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getdebutKm() {
        return debutKm;
    }

    public void setDebutKm(double debutKm) {
        this.debutKm = debutKm;
    }

    public double getfinKm() {
        return finKm;
    }

    public void setFinKm(double finKm) {
        this.finKm = finKm;
    }
    public Vehicule getVehicule() {
        return vehicule;
    }

    public void setVehicule(Vehicule vehicule) {
        this.vehicule = vehicule;
    }
}
