package com.vehicule.api.dto;

import com.vehicule.api.entity.Annonce;
import com.vehicule.api.entity.PhotoAnnonce;
import java.util.List;

public class AnnonceDTO {
    private Annonce annonce;
    private List<PhotoAnnonce> photos;
    private boolean liked;

    public AnnonceDTO(){}

    public AnnonceDTO(Annonce annonce,List<PhotoAnnonce> photos, boolean liked){
        this.setAnnonce(annonce);
        this.setPhotos(photos);
        this.setLiked(liked);
    }

    public Annonce getAnnonce() {
        return annonce;
    }

    public void setAnnonce(Annonce annonce) {
        this.annonce = annonce;
    }

    public List<PhotoAnnonce> getPhotos() {
        return photos;
    }

    public void setPhotos(List<PhotoAnnonce> photos) {
        this.photos = photos;
    }
    public boolean getLiked(){
        return this.liked;
    }
    public void setLiked(boolean liked){
        this.liked=liked;
    }
}