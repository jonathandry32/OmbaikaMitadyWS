package com.vehicule.api.controller;

import com.vehicule.api.entity.User;
import com.vehicule.api.repository.UserRepository;
import com.vehicule.api.services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    private final UserRepository userRepository;
    private final UserService userService;

    @Autowired
    public UserController(UserRepository userRepository,UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @PostMapping("/auth/sign")
    public User sign(String email, String nom, String password,String pdp)  {
        return userService.saveUser(email,nom,password,pdp);
    }
}
