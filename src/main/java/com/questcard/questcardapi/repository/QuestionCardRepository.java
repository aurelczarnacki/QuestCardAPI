package com.questcard.questcardapi.repository;

import com.questcard.questcardapi.model.QuestionCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionCardRepository extends JpaRepository<QuestionCard, Long> {
    // Dodatkowe metody zapytań można definiować tutaj, jeśli potrzebujesz
}