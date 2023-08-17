package com.questcard.questcardapi.repository;

import com.questcard.questcardapi.model.AppUser;
import com.questcard.questcardapi.model.Reputation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReputationRepository extends JpaRepository<Reputation, Long> {

    Reputation findByAppUserAndEntityTypeAndEntityId(AppUser appUser, String entityType, Long entityId);
}