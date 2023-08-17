package com.questcard.questcardapi.service;

import com.questcard.questcardapi.model.AppUser;
import com.questcard.questcardapi.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppUserService {

    private final AppUserRepository appUserRepository;

    @Autowired
    public AppUserService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    public AppUser getByEmail(String email) {
        return appUserRepository.findByEmail(email);
    }

    public void save(AppUser appUser) {
        appUserRepository.save(appUser);
    }

    public AppUser getById(Long id) {
        return appUserRepository.getById(id);
    }

    public boolean existsByEmail(String email) {
        return appUserRepository.existsByEmail(email);
    }
}