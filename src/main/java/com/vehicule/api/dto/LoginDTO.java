package com.vehicule.api.dto;

import com.vehicule.api.entity.User;

public class LoginDTO {
    private String token;
    private User user;

    public LoginDTO(){}

    public LoginDTO(String tkn,User user){
        this.setToken(tkn);
        this.setUser(user);
    }

    public String getToken() {
        return token;
    }

    public void setToken(String tkn) {
        this.token = tkn;
    }
    public User getUserId() {
        return user;
    }

    public void setUser(User usr) {
        this.user = usr;
    }
}