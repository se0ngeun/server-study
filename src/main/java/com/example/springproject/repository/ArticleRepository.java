package com.example.springproject.repository;

import com.example.springproject.entity.ArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ArticleRepository extends JpaRepository<ArticleEntity, Long> {

    Optional<ArticleEntity> findByUuid(UUID uuid);

    Optional<ArticleEntity> findById(UUID userid);
//    ArticleEntity findById(UUID uuid);
}
