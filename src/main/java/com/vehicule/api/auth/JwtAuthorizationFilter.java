package com.vehicule.api.auth;

import com.vehicule.api.entity.User;
import com.vehicule.api.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthorizationFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;
    private final ObjectMapper mapper;
    private final UserDetailsService userDetailsService;
    private UserRepository userRepository;

    public JwtAuthorizationFilter(JwtUtil jwtUtil, ObjectMapper mapper, UserDetailsService userDetailsService, UserRepository userRepository) {
        this.jwtUtil = jwtUtil;
        this.mapper = mapper;
        this.userDetailsService = userDetailsService;
        this.userRepository = userRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            String accessToken = jwtUtil.resolveToken(request);
            if (accessToken == null) {
                filterChain.doFilter(request, response);
                return;
            }

            Claims claims = jwtUtil.resolveClaims(request);

            if (claims != null && jwtUtil.validateClaims(claims)) {
                String email = claims.getSubject();
                UserDetails userDetails = userDetailsService.loadUserByUsername(email);

                if (userDetails != null) {
                    Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }

        } catch (Exception e) {
            System.out.println("Authentication error: " + e.getMessage());
        }

        filterChain.doFilter(request, response);
    }

}
