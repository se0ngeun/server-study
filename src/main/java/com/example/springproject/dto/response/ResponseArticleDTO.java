package com.example.springproject.dto.response;

import com.example.springproject.entity.ArticleEntity;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ResponseArticleDTO extends Throwable {

    private UUID userid; // 사용자 id

    private UUID uuid; // 글 id

    private String name; // 제목

    private String description; // 설명

//    private String writer; // 해당 글 작성자 id

    private LocalDate createDate; // 작성 날짜

    public static ResponseArticleDTO toArticleEntity(ArticleEntity articleEntity) {
        ResponseArticleDTO responseArticleDTO = new ResponseArticleDTO();

        responseArticleDTO.setUserid(articleEntity.getUserid());
        responseArticleDTO.setUuid(articleEntity.getUuid());
        responseArticleDTO.setName(responseArticleDTO.getName());
        responseArticleDTO.setDescription(responseArticleDTO.getDescription());
        responseArticleDTO.setCreateDate(responseArticleDTO.getCreateDate());

        return responseArticleDTO;
    }
    }

//    private String errorMessage;

