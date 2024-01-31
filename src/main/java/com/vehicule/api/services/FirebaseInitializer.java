package com.vehicule.api.services;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;

@Service
public class FirebaseInitializer {

    @PostConstruct
    public void initialize() throws IOException {
        InputStream serviceAccount = getClass().getClassLoader().getResourceAsStream("ombaikamitady-firebase-adminsdk-zojey-53fb3bbd75.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setStorageBucket("ombaikamitady.appspot.com")
                .build();
        FirebaseApp.initializeApp(options);
    }
}
