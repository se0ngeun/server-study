package com.example.springproject.dto.request;

import lombok.*;

import java.util.UUID;

//@Getter
//@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class RequestArticleDTO {

    private String name; // 제목

    private String description; // 설명



}