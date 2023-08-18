package com.questcard.questcardapi.service;

import com.questcard.questcardapi.model.entity.AppUser;
import com.questcard.questcardapi.model.entity.Role;
import com.questcard.questcardapi.repository.AppUserRepository;
import com.questcard.questcardapi.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppUserService {

    private final AppUserRepository appUserRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public AppUserService(AppUserRepository appUserRepository, RoleRepository roleRepository) {
        this.appUserRepository = appUserRepository;
        this.roleRepository = roleRepository;
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

    public Role findRoleByRoleName(String roleName) {
        return roleRepository.findByRoleName(roleName);
    }
}