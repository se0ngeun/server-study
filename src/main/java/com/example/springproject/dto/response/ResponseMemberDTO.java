package com.example.springproject.dto.response;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ResponseMemberDTO {

    private UUID userid;

    private String password;

    private String nickname;

    private Long phone;
}
