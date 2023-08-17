package com.questcard.questcardapi.model;

import com.questcard.questcardapi.security.AuthUserDetails;

import javax.persistence.*;
import java.util.Date;

@Entity
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String hashedPassword;

    private String name;

    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

    private int reputation;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfRegister;

    private String photoUrl;

    @ManyToOne
    @JoinColumn(name = "role_id")
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getReputation() {
        return reputation;
    }

    public void setReputation(int reputation) {
        this.reputation = reputation;
    }

    public Date getDateOfRegister() {
        return dateOfRegister;
    }

    public void setDateOfRegister(Date dateOfRegister) {
        this.dateOfRegister = dateOfRegister;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
