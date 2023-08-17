package com.questcard.questcardapi.model;

import javax.persistence.*;

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

    public Long getQuestionCardId() {
        return questionCardId;
    }

    public void setQuestionCardId(Long questionCardId) {
        this.questionCardId = questionCardId;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getPickCount() {
        return pickCount;
    }

    public void setPickCount(int pickCount) {
        this.pickCount = pickCount;
    }
}