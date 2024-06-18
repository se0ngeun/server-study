package com.example.springproject.service;

import com.example.springproject.dto.request.RequestArticleDTO;
import com.example.springproject.dto.response.ResponseArticleDTO;
import com.example.springproject.entity.ArticleEntity;
import com.example.springproject.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.NotFound;
import org.springframework.dao.PermissionDeniedDataAccessException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;

    public void save(RequestArticleDTO requestarticleDTO, LocalDate createDate, UUID userId) {
        // 1. dto -> entity 변환
        // 2. repository의 save 메서드 호출
        ArticleEntity articleEntity = ArticleEntity.toArticleEntity(requestarticleDTO);
        articleEntity.setUserid(userId);
        articleEntity.setCreateDate(createDate);
        articleRepository.save(articleEntity);
    }

    public void deleteById(RequestArticleDTO requestarticleDTO, UUID userid) {
//        Optional<ArticleEntity> articleEntity = articleRepository.findById(userId);
        ArticleEntity articleEntity = ArticleEntity.toArticleEntity(requestarticleDTO);

        if ((articleEntity.getUserid()).equals(userid)) {
            articleRepository.deleteAll(); // deleteById에 대해서 확인!

        } else {
//            return new CustomError(ErrorState.NOT_FOUND_ID);
//            throw new Exception(No)
            // 페이지에서 권한이 없습니다. 띄우기
            throw new RuntimeException("권한이 없습니다.");

        }

    }

    public List<ResponseArticleDTO> findAll() {
        List<ArticleEntity> articleEntityList = articleRepository.findAll();
        List<ResponseArticleDTO> responseArticleDTOList = new ArrayList<>();

        for(ArticleEntity articleEntity : articleEntityList) {
            responseArticleDTOList.add(ResponseArticleDTO.toArticleEntity(articleEntity));

        }
        return responseArticleDTOList;
    }

    public ResponseArticleDTO findById(UUID uuid) {
        Optional<ArticleEntity> articleEntityOptional = articleRepository.findByUuid(uuid);
        if ( articleEntityOptional.isPresent()) {
            return ResponseArticleDTO.toArticleEntity(articleEntityOptional.get());
        } else {
            return null;
        }
    }

    public void update(RequestArticleDTO requestArticleDTO, UUID uuid, UUID userid, LocalDate createDate) {
        ArticleEntity articleEntity = ArticleEntity.toArticleEntity(requestArticleDTO);

        if ((articleEntity.getUserid()).equals(userid)) {
            Optional<ArticleEntity> articleOptional = articleRepository.findByUuid(uuid);
            if (articleOptional.isPresent()) {
                ArticleEntity article = articleOptional.get();
                article = ArticleEntity.builder()
                        .name(requestArticleDTO.getName())
                        .description(requestArticleDTO.getDescription())
                        .userid(userid)
                        .createDate(createDate)
                        .build();

                articleRepository.save(article);
            } else {
                throw new RuntimeException("");
            }
        } else {
            throw new RuntimeException("권한이 없습니다.");
        }
    }
}
