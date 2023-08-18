package com.questcard.questcardapi.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Entity
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    @JsonProperty("password")
    private String hashedPassword;

    @Column(nullable = false, unique = true)
    private String name;

    private Date dateOfBirth;

    private int reputation;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfRegister;

    private String photoUrl;

    @ManyToOne
    @JoinColumn(name = "role_Id")
    private Role role;

    public AppUser(String email, String hashedPassword, String name, Date dateOfBirth, int reputation,Date dateOfRegister, String photoUrl, Role role) {
        this.email = email;
        this. hashedPassword = hashedPassword;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.reputation = reputation;
        this.dateOfRegister = dateOfRegister;
        this.photoUrl = photoUrl;
        this.role = role;
    }

    public AppUser(String email, String hashedPassword) {
        this.email = email;
        this.hashedPassword = hashedPassword;
    }

    public AppUser(){

    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setReputation(int reputation) {
        this.reputation = reputation;
    }

    public void setDateOfRegister(Date dateOfRegister) {
        this.dateOfRegister = dateOfRegister;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
