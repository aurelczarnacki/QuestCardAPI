package com.questcard.questcardapi.service;

import com.questcard.questcardapi.model.entity.AppUser;
import com.questcard.questcardapi.model.entity.Quiz;
import com.questcard.questcardapi.repository.AppUserRepository;
import com.questcard.questcardapi.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class QuizService {

    private final QuizRepository quizRepository;
    private final AppUserService appUserService;
    private final AppUserRepository appUserRepository;

    @Autowired
    public QuizService(QuizRepository quizRepository, AppUserService appUserService, AppUserRepository appUserRepository) {
        this.quizRepository = quizRepository;
        this.appUserService = appUserService;
        this.appUserRepository = appUserRepository;
    }

    public void createQuiz(Quiz quiz) {
        quizRepository.save(quiz);
    }

    public void deleteQuiz(Long quizId) {
        quizRepository.deleteById(quizId);
    }

    public void addManagerToQuiz(Long quizId, Long managerId) {
        Quiz quiz = getQuizById(quizId);
        AppUser manager = appUserService.getById(managerId);

        if (quiz != null && manager != null) {
            quiz.getManagers().add(manager);
            quizRepository.save(quiz);
        }
    }

    public List<Quiz> getQuizzesByOwner(Long ownerId) {
        AppUser owner = appUserRepository.findById(ownerId).orElse(null);
        if (owner != null) {
            return quizRepository.findByOwner(owner);
        } else {
            return Collections.emptyList();
        }
    }

    public Quiz getQuizById(Long quizId) {
        return quizRepository.findById(quizId).orElse(null);
    }

    // Dodaj inne metody obsługujące edycję quizu, wyświetlanie quizów po tagach, kategoriach itp.
}