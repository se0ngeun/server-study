package com.example.springproject.repository;

import com.example.springproject.entity.ArticleEntity;
import com.example.springproject.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
//    String save(MemberEntity memberEntity);

    Optional<MemberEntity> findById(UUID userid);
}
