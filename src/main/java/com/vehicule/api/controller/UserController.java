package com.vehicule.api.controller;

import com.vehicule.api.entity.User;
import com.vehicule.api.repository.UserRepository;
import com.vehicule.api.services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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
    
    @GetMapping("/users/{id}")
    public User find(@PathVariable("id") Long id){
        return userRepository.findById(id).get();
    }
    
    @GetMapping("/users")
    public List<User> findAll(){
        return userRepository.findAll();
    }

    //-----ATPRES DEployement
    @PostMapping("/auth/signApp")
    public User sign(@RequestBody Map<String, Object> requestBody) throws Exception {
        try{
            String email = (String) requestBody.get("mail");
            String password = (String) requestBody.get("password");
            String nom = (String) requestBody.get("username");
            String pdpUrl = (String) requestBody.get("pdpUrl");

            return userService.saveUser(email,nom,password,pdpUrl);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

    }
}
