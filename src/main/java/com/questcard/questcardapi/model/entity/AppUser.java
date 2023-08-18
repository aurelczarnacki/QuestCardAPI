package com.questcard.questcardapi.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;
import javax.persistence.*;
import java.util.Date;

@Getter
@Entity
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Password is required")
    @JsonProperty("password")
    private String hashedPassword;

    @NotBlank(message = "Name is required")
    @Column(unique = true)
    private String name;

    @Past(message = "Date of birth must be in the past")
    private Date dateOfBirth;

    @Min(value = 0, message = "Reputation must be a non-negative value")
    private int reputation;

    @Temporal(TemporalType.TIMESTAMP)
    @NotNull(message = "Registration date is required")
    private Date dateOfRegister;

    private String photoUrl;

    @ManyToOne
    @JoinColumn(name = "role_Id")
    @NotNull(message = "Role is required")
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
