package com.vehicule.api.entity;

import jakarta.persistence.*;

@Entity
@Table
public class PhotoAnnonce {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_photo_annonce")
    private Long idPhotoAnnonce;

    @ManyToOne
    @JoinColumn(name = "id_annonce", nullable = false)
    private Annonce annonce;

    @Column(name = "lien_photo")
    private String lienPhoto;

    public PhotoAnnonce() {
    }

    public PhotoAnnonce(Annonce annonce, String lienPhoto) {
        this.annonce = annonce;
        this.lienPhoto = lienPhoto;
    }

    public Long getIdPhotoAnnonce() {
        return idPhotoAnnonce;
    }

    public void setIdPhotoAnnonce(Long idPhotoAnnonce) {
        this.idPhotoAnnonce = idPhotoAnnonce;
    }

    public Annonce getAnnonce() {
        return annonce;
    }

    public void setAnnonce(Annonce annonce) {
        this.annonce = annonce;
    }

    public String getLienPhoto() {
        return lienPhoto;
    }

    public void setLienPhoto(String lienPhoto) {
        this.lienPhoto = lienPhoto;
    }
}
