package com.questcard.questcardapi.repository;

import com.questcard.questcardapi.model.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
}