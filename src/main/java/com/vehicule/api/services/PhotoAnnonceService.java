package com.vehicule.api.services;


import com.vehicule.api.entity.PhotoAnnonce;
import com.vehicule.api.entity.Annonce;
import com.vehicule.api.repository.PhotoAnnonceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.util.Objects;
import com.google.cloud.storage.*;

import java.util.List;
import java.io.IOException;

@Service
public class PhotoAnnonceService {
    private final PhotoAnnonceRepository photoannonceRepository;

    @Autowired
    public PhotoAnnonceService(PhotoAnnonceRepository photoannonceRepository) {
        this.photoannonceRepository = photoannonceRepository;
    }

    public PhotoAnnonce savePhotoAnnonce(Annonce ann,String lienPhoto){
        PhotoAnnonce mq = new PhotoAnnonce();
        mq.setAnnonce(ann);
        mq.setLienPhoto(lienPhoto);
        mq = photoannonceRepository.save(mq);
        return mq;
    }
    
    public String uploadPhoto(MultipartFile file) throws IOException {
        Storage storage = StorageOptions.getDefaultInstance().getService();
        String bucketName = "ombaikamitady.appspot.com";
        String fileName = Objects.requireNonNull(file.getOriginalFilename());

        BlobId blobId = BlobId.of(bucketName, fileName);
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).build();

        storage.create(blobInfo, file.getBytes());

        return storage.get(bucketName, fileName).getMediaLink();
    }

    public List<PhotoAnnonce> getPhotosByAnnonceId(Long idAnnonce) {
        return photoannonceRepository.findByAnnonceId(idAnnonce);
    }
}
