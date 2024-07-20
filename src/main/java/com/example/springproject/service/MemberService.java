package com.example.springproject.service;

import com.example.springproject.dto.request.RequestMemberDTO;
import com.example.springproject.entity.MemberEntity;
import com.example.springproject.repository.ArticleRepository;
import com.example.springproject.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public String signup(RequestMemberDTO requestMemberDTO) {
        // 1. dto -> entity 변환
        // 2. repository의 save 메서드 호출
        MemberEntity memberEntity = MemberEntity.toMemberEntity(requestMemberDTO);
        memberRepository.save(memberEntity);
        // repository의 save메서드 호출 (조건. entity객체를 넘겨줘야 함)
        return "회원가입 성공";
    }

    public RequestMemberDTO login(RequestMemberDTO requestMemberDTO){
        /*
            1. 회원이 입력한 이메일로 DB에서 조회를 함
            2. DB에서 조회한 비밀번호와 사용자가 입력한 비밀번호가 일치하는지 판단
         */
        Optional<MemberEntity> byMemberEmail = memberRepository.findById(requestMemberDTO.getUserid());
        if (byMemberEmail.isPresent()) {
            // 조회 결과가 있다(해당 이메일을 가진 회원 정보가 있다)
            MemberEntity memberEntity = byMemberEmail.get();
            if (memberEntity.getPassword().equals(requestMemberDTO.getPassword())) {
                // 비밀번호 일치
                // entity -> dto 변환 후 리턴
                RequestMemberDTO dto = requestMemberDTO.toMemberDTO(memberEntity);
                return dto;
            } else {
                // 비밀번호 불일치(로그인실패)
                return null;
            }
        } else {
            // 조회 결과가 없다(해당 이메일을 가진 회원이 없다)
            return null;
        }
    }
}
