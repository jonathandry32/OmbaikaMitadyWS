package com.vehicule.api.controller;

import com.vehicule.api.auth.JwtUtil;
import com.vehicule.api.entity.User;
import com.vehicule.api.dto.LoginDTO;
import com.vehicule.api.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import java.util.Map;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private UserRepository userRepository;
    private JwtUtil jwtUtil;

    public AuthController(AuthenticationManager authenticationManager, JwtUtil jwtUtil, UserRepository userRepository) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
    }

   @PostMapping("/auth/login")
    public LoginDTO login(String mail, String password) throws Exception {
        try {
            Authentication authentication =
                    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(mail, password));
            User user = userRepository.findByEmail(mail);
            String token = jwtUtil.createToken(user);
            LoginDTO responseDTO = new LoginDTO();
            responseDTO.setToken(token);
            responseDTO.setUser(user);
            return responseDTO;

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
        @PostMapping("/auth/loginApp")
        public LoginDTO loginapp(@RequestBody Map<String, Object> requestBody) throws Exception {
            String mail = (String) requestBody.get("mail");
            String password = (String) requestBody.get("password");

            try {
                Authentication authentication =
                        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(mail, password));
                User user = userRepository.findByEmail(mail);
                String token = jwtUtil.createToken(user);
                LoginDTO responseDTO = new LoginDTO();
                responseDTO.setToken(token);
                responseDTO.setUser(user);
                return responseDTO;

            }catch (Exception e){
                throw new Exception(mail+" "+password);
            }
        }
}