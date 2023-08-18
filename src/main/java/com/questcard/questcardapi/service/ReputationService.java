package com.questcard.questcardapi.service;

import com.questcard.questcardapi.model.entity.AppUser;
import com.questcard.questcardapi.model.entity.Reputation;
import com.questcard.questcardapi.repository.ReputationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReputationService {

    private final ReputationRepository reputationRepository;
    private final AppUserService appUserService;

    @Autowired
    public ReputationService(ReputationRepository reputationRepository, AppUserService appUserService) {
        this.reputationRepository = reputationRepository;
        this.appUserService = appUserService;
    }

    @Transactional
    public boolean addReputation(Long userId, String entityType, Long entityId) {
        AppUser user = appUserService.getById(userId);
        if (user == null) {
            return false;
        }

        Reputation reputation = new Reputation(user, entityType, entityId);
        reputationRepository.save(reputation);
        return true;
    }

    @Transactional
    public boolean removeReputation(Long userId, String entityType, Long entityId) {
        AppUser user = appUserService.getById(userId);
        if (user == null) {
            return false;
        }

        Reputation reputation = reputationRepository.findByAppUserAndEntityTypeAndEntityId(user, entityType, entityId);
        if (reputation != null) {
            reputationRepository.delete(reputation);
            return true;
        }
        return false;
    }
}