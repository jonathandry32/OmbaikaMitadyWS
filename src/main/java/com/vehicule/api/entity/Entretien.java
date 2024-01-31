package com.vehicule.api.entity;

import jakarta.persistence.*;
import java.util.Date;
import java.text.SimpleDateFormat;
@Entity
@Table
public class Entretien {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private Date date;
    private String remarque;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_vehicule",referencedColumnName="id")
    private Vehicule vehicule;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_type_entretien",referencedColumnName="id")
    private TypeEntretien typeEntretien;

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

    public Vehicule getVehicule() {
        return vehicule;
    }

    public void setVehicule(Vehicule vehicule) {
        this.vehicule = vehicule;
    }
    
    public TypeEntretien getTypeEntretien() {
        return typeEntretien;
    }

    public void setTypeEntretien(TypeEntretien typeEntretien) {
        this.typeEntretien = typeEntretien;
    }
    public String getRemarque() {
        return remarque;
    }

    public void setRemarque(String remarque) {
        this.remarque = remarque;
    }
}
