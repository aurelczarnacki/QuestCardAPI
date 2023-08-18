package com.questcard.questcardapi.model;

import lombok.Getter;

@Getter
public class AuthRequest {
    private String password;

    private String email;

    public AuthRequest() {
    }

    public AuthRequest(String username, String password, String email) {
        this.password = password;
        this.email = email;
    }

    public void setEmail(String email) { this.email = email; }

    public void setPassword(String password) {
        this.password = password;
    }
}