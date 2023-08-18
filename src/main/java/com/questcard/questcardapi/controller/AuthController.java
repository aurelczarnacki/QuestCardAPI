package com.questcard.questcardapi.controller;

import com.questcard.questcardapi.model.entity.Role;
import com.questcard.questcardapi.security.CustomPasswordEncoder;
import com.questcard.questcardapi.model.entity.AppUser;
import com.questcard.questcardapi.model.AuthRequest;
import com.questcard.questcardapi.model.AuthResponse;
import com.questcard.questcardapi.security.jwt.JwtTokenProvider;
import com.questcard.questcardapi.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final AppUserService appUserService;
    private final CustomPasswordEncoder passwordEncoder;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider, AppUserService appUserService, CustomPasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.appUserService = appUserService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest data) {
        try {
            String email = data.getEmail();
            String password = data.getPassword();

            AppUser appUser = appUserService.getByEmail(email);
            if (appUser == null) {
                return ResponseEntity.badRequest().body("User not found");
            }

            // Authenticate the user
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(email, password)
            );

            // Generate JWT token
            String token = jwtTokenProvider.createToken(email);

            return ResponseEntity.ok(new AuthResponse(token));
        } catch (AuthenticationException e) {
            return ResponseEntity.badRequest().body("Authentication failed");
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody AppUser data) {
        if (appUserService.existsByEmail(data.getEmail())) {
            return ResponseEntity.badRequest().body("Email already taken");
        }

        String hashedPassword = passwordEncoder.encode(data.getHashedPassword());
        data.setHashedPassword(hashedPassword);
        data.setDateOfRegister(new Date());

        Role userRole = appUserService.findRoleByRoleName("user");
        data.setRole(userRole);

        appUserService.save(data);

        return ResponseEntity.ok("User registered successfully");
    }
}