package com.questcard.questcardapi.controller;

import com.questcard.questcardapi.model.entity.Quiz;
import com.questcard.questcardapi.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quizzes")
public class QuizController {

    private final QuizService quizService;

    @Autowired
    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @PostMapping
    public ResponseEntity<String> createQuiz(@RequestBody Quiz quiz) {
        // Utwórz nowy quiz
        quizService.createQuiz(quiz);
        return new ResponseEntity<>("Quiz created successfully", HttpStatus.CREATED);
    }

    @DeleteMapping("/{quizId}")
    public ResponseEntity<String> deleteQuiz(@PathVariable Long quizId) {
        // Usuń quiz o podanym id
        quizService.deleteQuiz(quizId);
        return new ResponseEntity<>("Quiz deleted successfully", HttpStatus.OK);
    }

    @PutMapping("/{quizId}/add-manager/{managerId}")
    public ResponseEntity<String> addManagerToQuiz(@PathVariable Long quizId, @PathVariable Long managerId) {
        // Dodaj managera do quizu
        quizService.addManagerToQuiz(quizId, managerId);
        return new ResponseEntity<>("Manager added to quiz successfully", HttpStatus.OK);
    }

    // Dodaj inne metody obsługujące edycję quizu, wyświetlanie quizów itp.

    @GetMapping("/by-owner/{ownerId}")
    public ResponseEntity<List<Quiz>> getQuizzesByOwner(@PathVariable Long ownerId) {
        // Pobierz quizy po id właściciela
        List<Quiz> quizzes = quizService.getQuizzesByOwner(ownerId);
        return new ResponseEntity<>(quizzes, HttpStatus.OK);
    }

    // Dodaj inne metody obsługujące wyświetlanie quizów po tagach, kategoriach itp.
}