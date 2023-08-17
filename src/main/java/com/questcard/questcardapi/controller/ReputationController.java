package com.questcard.questcardapi.controller;

import com.questcard.questcardapi.model.Reputation;
import com.questcard.questcardapi.service.ReputationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reputation")
public class ReputationController {

    private final ReputationService reputationService;

    @Autowired
    public ReputationController(ReputationService reputationService) {
        this.reputationService = reputationService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addReputation(
            @RequestParam Long userId,
            @RequestParam String entityType,
            @RequestParam Long entityId) {
        if (reputationService.addReputation(userId, entityType, entityId)) {
            return new ResponseEntity<>("Reputation added successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Failed to add reputation", HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/remove")
    public ResponseEntity<String> removeReputation(
            @RequestParam Long userId,
            @RequestParam String entityType,
            @RequestParam Long entityId) {
        if (reputationService.removeReputation(userId, entityType, entityId)) {
            return new ResponseEntity<>("Reputation removed successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Failed to remove reputation", HttpStatus.BAD_REQUEST);
    }
}