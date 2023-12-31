package com.questcard.questcardapi.model.entity;

import lombok.Getter;
import javax.persistence.*;
import java.util.Date;

@Getter
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    @ManyToOne
    @JoinColumn(name = "user_id") // Nazwa kolumny klucza obcego w tabeli Comment
    private AppUser appUser; // Relacja z encją AppUser

    @Column(nullable = false)
    private String text;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date datePosted;

    private int reputation;

    @ManyToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;

    public Comment() {
    }

    public Comment(AppUser appUser, String text, Date datePosted, int reputation, Quiz quiz) {
        this.appUser = appUser;
        this.text = text;
        this.datePosted = datePosted;
        this.reputation = reputation;
        this.quiz = quiz;
    }


    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public AppUser getUser() {
        return appUser;
    }

    public void setUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setDatePosted(Date datePosted) {
        this.datePosted = datePosted;
    }

    public void setReputation(int reputation) {
        this.reputation = reputation;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }
}