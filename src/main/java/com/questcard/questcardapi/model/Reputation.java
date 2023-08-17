package com.questcard.questcardapi.model;

import javax.persistence.*;

@Entity
public class Reputation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long repId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private AppUser appUser;

    @Column(nullable = false)
    private String entityType;

    @Column(nullable = false)
    private Long entityId;

    public Reputation() {
    }

    public Reputation(AppUser appUser, String entityType, Long entityId) {
        this.appUser = appUser;
        this.entityType = entityType;
        this.entityId = entityId;
    }

    public Long getRepId() {
        return repId;
    }

    public void setRepId(Long repId) {
        this.repId = repId;
    }

    public AppUser getUser() {
        return appUser;
    }

    public void setUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public String getEntityType() {
        return entityType;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    public Long getEntityId() {
        return entityId;
    }

    public void setEntityId(Long entityId) {
        this.entityId = entityId;
    }
}