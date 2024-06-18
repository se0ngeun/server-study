package com.example.springproject.dto.request;

import com.example.springproject.dto.response.ResponseArticleDTO;
import com.example.springproject.entity.MemberEntity;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class RequestMemberDTO {

    private UUID userid;

    private String password;

    private String nickname;

    private Long phone;


    public RequestMemberDTO toMemberDTO(MemberEntity memberEntity) {
        RequestMemberDTO requestMemberDTO = new RequestMemberDTO();

        requestMemberDTO.setUserid(memberEntity.getUserid());
        requestMemberDTO.setPassword(memberEntity.getPassword());
        requestMemberDTO.setNickname(memberEntity.getNickname());
        requestMemberDTO.setPhone(memberEntity.getPhone());

        return requestMemberDTO;
    }
}
