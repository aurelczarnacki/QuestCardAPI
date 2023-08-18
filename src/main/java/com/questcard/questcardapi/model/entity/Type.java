package com.questcard.questcardapi.model.entity;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long typeId;

    @Column(nullable = false, unique = true)
    private String name;

    public Type() {
    }

    public Type(String name) {
        this.name = name;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public void setName(String name) {
        this.name = name;
    }
}