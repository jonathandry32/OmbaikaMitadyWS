package com.vehicule.api.repository;
import java.util.List;


import com.vehicule.api.entity.PhotoAnnonce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PhotoAnnonceRepository extends JpaRepository<PhotoAnnonce, Long> {

    @Query("SELECT pa FROM PhotoAnnonce pa WHERE pa.annonce.idAnnonce = :idAnnonce")
    List<PhotoAnnonce> findByAnnonceId(Long idAnnonce);
}
