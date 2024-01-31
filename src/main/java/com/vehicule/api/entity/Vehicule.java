package com.vehicule.api.entity;

import jakarta.persistence.*;

@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(
                name = "matricule_unique",
                columnNames = "matricule"
        )
})
public class Vehicule {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(nullable = false)
    private String matricule;
    @Column(nullable = false)
    private String marque;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }
}
