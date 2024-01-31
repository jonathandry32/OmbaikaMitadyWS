package com.vehicule.api.services;

import com.vehicule.api.entity.User;
import com.vehicule.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;


@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User saveUser(String email,String nom,String password,String pdp){
        User user = new User();
        user.setEmail(email);
        user.setNom(nom);
        String encryptedPassword = passwordEncoder.encode(password);
        user.setPassword(encryptedPassword);
        user.setPhotoProfil(pdp);
        user = userRepository.save(user);
        return user;
    }
}
