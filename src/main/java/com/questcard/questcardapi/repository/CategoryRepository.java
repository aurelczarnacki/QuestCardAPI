package com.questcard.questcardapi.repository;

import com.questcard.questcardapi.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    // Możesz dodać własne metody zapytań, jeśli są potrzebne
}