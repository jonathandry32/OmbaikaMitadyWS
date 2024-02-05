package com.vehicule.api.entity;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Users")
public class User {
    public User() {}

    public User(String nom, String password, String email) {
        this.nom = nom;
        this.password = password;
        this.email = email;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String nom;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String email;
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String password;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
    public String getPhotoProfil() {
        return photoprofil;
    }

    public void setPhotoProfil(String pdp) {
        this.photoprofil = pdp;
    }

    private String photoprofil;
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(nom, user.nom) &&
                Objects.equals(email, user.email) &&
                Objects.equals(password, user.password) &&
                Objects.equals(photoprofil, user.photoprofil);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom, email, password, photoprofil);
    }
}