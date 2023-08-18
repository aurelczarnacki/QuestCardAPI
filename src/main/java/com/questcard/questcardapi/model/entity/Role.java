package com.questcard.questcardapi.model.entity;

import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Getter
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;

    @Column(nullable = false, unique = true)
    private String roleName;

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
    private List<AppUser> users;

    // ... konstruktory, gettery, settery ...

    public Role() {
    }

    public Role(String roleName) {
        this.roleName = roleName;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public void setUsers(List<AppUser> users) {
        this.users = users;
    }
}