package com.questcard.questcardapi.repository;

import com.questcard.questcardapi.model.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    // Dodatkowe metody zapytań można definiować tutaj

    AppUser findByEmail(String email);

    boolean existsByEmail(String email);
}