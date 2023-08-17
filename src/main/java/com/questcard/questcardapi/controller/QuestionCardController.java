package com.questcard.questcardapi.controller;

import com.questcard.questcardapi.model.QuestionCard;
import com.questcard.questcardapi.service.QuestionCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question-cards")
public class QuestionCardController {

    private final QuestionCardService questionCardService;

    @Autowired
    public QuestionCardController(QuestionCardService questionCardService) {
        this.questionCardService = questionCardService;
    }

    @GetMapping("/{questionCardId}")
    public ResponseEntity<QuestionCard> getQuestionCardById(@PathVariable Long questionCardId) {
        QuestionCard questionCard = questionCardService.getQuestionCardById(questionCardId);
        if (questionCard != null) {
            return ResponseEntity.ok(questionCard);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<QuestionCard>> getAllQuestionCards() {
        List<QuestionCard> questionCards = questionCardService.getAllQuestionCards();
        return ResponseEntity.ok(questionCards);
    }

    @PostMapping
    public ResponseEntity<QuestionCard> createQuestionCard(@RequestBody QuestionCard questionCard) {
        QuestionCard createdQuestionCard = questionCardService.createQuestionCard(questionCard);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdQuestionCard);
    }

    @PutMapping("/{questionCardId}")
    public ResponseEntity<QuestionCard> updateQuestionCard(
            @PathVariable Long questionCardId,
            @RequestBody QuestionCard updatedQuestionCard
    ) {
        QuestionCard updatedCard = questionCardService.updateQuestionCard(questionCardId, updatedQuestionCard);
        if (updatedCard != null) {
            return ResponseEntity.ok(updatedCard);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{questionCardId}")
    public ResponseEntity<Void> deleteQuestionCard(@PathVariable Long questionCardId) {
        boolean isDeleted = questionCardService.deleteQuestionCard(questionCardId);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}