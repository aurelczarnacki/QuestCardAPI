package com.questcard.questcardapi.repository;

import com.questcard.questcardapi.model.entity.AppUser;
import com.questcard.questcardapi.model.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {

    List<Quiz> findByOwner(AppUser owner);
    // Dodaj inne metody zapytań potrzebne do operacji na quizach
}