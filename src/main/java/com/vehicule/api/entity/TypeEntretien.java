package com.vehicule.api.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "TypeEntretien",uniqueConstraints = {
        @UniqueConstraint(
                name = "nom_unique",
                columnNames = "nom"
        )
})
public class TypeEntretien {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(nullable = false)
    private String nom;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
