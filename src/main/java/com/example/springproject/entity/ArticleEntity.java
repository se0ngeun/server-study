package com.example.springproject.entity;

import com.example.springproject.dto.request.RequestArticleDTO;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Builder
@Entity
@Getter
@Setter
@Table(name = "article_table")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ArticleEntity {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private UUID userid; // 사용자 id

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID uuid; // 글 id


    @Column
    private String name; // 제목

    @Column
    private String description; // 설명

//    @Column
//    private String writer; // 해당 글 작성자 id

    private LocalDate createDate; // 작성 날짜

    public static ArticleEntity toArticleEntity(RequestArticleDTO requestarticleDTO) {
        ArticleEntity articleEntity = new ArticleEntity();

        articleEntity.setName(requestarticleDTO.getName());
        articleEntity.setDescription(requestarticleDTO.getDescription());

        return articleEntity;

    }
}
