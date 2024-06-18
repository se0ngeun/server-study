package com.example.springproject.entity;

import com.example.springproject.dto.request.RequestMemberDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Builder
@Entity
@Getter
@Setter
@Table(name = "member_table")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID userid;

    @Column
    private String password;

    @Column
    private String nickname;

    @Column
    private Long phone;

    public static MemberEntity toMemberEntity(RequestMemberDTO requestMemberDTO) {
        MemberEntity memberEntity = new MemberEntity();

        memberEntity.setUserid(requestMemberDTO.getUserid());
        memberEntity.setPassword(requestMemberDTO.getPassword());
        memberEntity.setNickname(requestMemberDTO.getNickname());
        memberEntity.setPhone(requestMemberDTO.getPhone());

        return memberEntity;

    }
}
