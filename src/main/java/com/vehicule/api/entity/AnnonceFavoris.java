package com.vehicule.api.entity;

import jakarta.persistence.*;
import java.util.Date;
import java.text.SimpleDateFormat;
@Entity
@Table
public class AnnonceFavoris {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idAnnonceFavoris;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="users",referencedColumnName="id")
    private User user;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="idAnnonce",referencedColumnName="idAnnonce")
    private Annonce annonce;

    public Long getIdAnnonceFavoris() {
        return idAnnonceFavoris;
    }

    public void setIdAnnonceFavoris(Long id) {
        this.idAnnonceFavoris = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    public Annonce getAnnonce() {
        return annonce;
    }

    public void setAnnonce(Annonce annonce) {
        this.annonce = annonce;
    }
}
