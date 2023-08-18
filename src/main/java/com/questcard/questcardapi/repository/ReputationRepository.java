package com.questcard.questcardapi.repository;

import com.questcard.questcardapi.model.entity.AppUser;
import com.questcard.questcardapi.model.entity.Reputation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReputationRepository extends JpaRepository<Reputation, Long> {

    Reputation findByAppUserAndEntityTypeAndEntityId(AppUser appUser, String entityType, Long entityId);
}