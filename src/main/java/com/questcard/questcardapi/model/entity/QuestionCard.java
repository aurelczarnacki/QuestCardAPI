package com.questcard.questcardapi.model.entity;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class QuestionCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionCardId;

    @ManyToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;

    private String photoUrl;
    private String text;
    private int pickCount;

    public QuestionCard() {
    }

    public QuestionCard(Quiz quiz, String photoUrl, String text, int pickCount) {
        this.quiz = quiz;
        this.photoUrl = photoUrl;
        this.text = text;
        this.pickCount = pickCount;
    }

    public void setQuestionCardId(Long questionCardId) {
        this.questionCardId = questionCardId;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setPickCount(int pickCount) {
        this.pickCount = pickCount;
    }
}