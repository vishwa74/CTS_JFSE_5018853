package com.example.bookstoreapi.controller;

import com.example.bookstoreapi.security.JwtUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    private final JwtUtil jwtUtil;

    public AuthController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/api/auth/login")
    public String login(@RequestBody AuthRequest authRequest) {
        // Validate the credentials (add actual validation logic here)
        String token = jwtUtil.generateToken(authRequest.getUsername());
        return token;
    }
}
