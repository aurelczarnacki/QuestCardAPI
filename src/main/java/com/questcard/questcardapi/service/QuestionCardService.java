package com.questcard.questcardapi.service;

import com.questcard.questcardapi.model.entity.QuestionCard;
import com.questcard.questcardapi.repository.QuestionCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionCardService {

    private final QuestionCardRepository questionCardRepository;

    @Autowired
    public QuestionCardService(QuestionCardRepository questionCardRepository) {
        this.questionCardRepository = questionCardRepository;
    }

    public QuestionCard getQuestionCardById(Long questionCardId) {
        return questionCardRepository.findById(questionCardId).orElse(null);
    }

    public List<QuestionCard> getAllQuestionCards() {
        return questionCardRepository.findAll();
    }

    public QuestionCard createQuestionCard(QuestionCard questionCard) {
        return questionCardRepository.save(questionCard);
    }

    public QuestionCard updateQuestionCard(Long questionCardId, QuestionCard updatedQuestionCard) {
        QuestionCard existingQuestionCard = questionCardRepository.findById(questionCardId).orElse(null);
        if (existingQuestionCard != null) {
            // Update properties of existingQuestionCard using updatedQuestionCard
            // For example: existingQuestionCard.setText(updatedQuestionCard.getText());
            return questionCardRepository.save(existingQuestionCard);
        }
        return null;
    }

    public boolean deleteQuestionCard(Long questionCardId) {
        QuestionCard existingQuestionCard = questionCardRepository.findById(questionCardId).orElse(null);
        if (existingQuestionCard != null) {
            questionCardRepository.delete(existingQuestionCard);
            return true;
        }
        return false;
    }
}