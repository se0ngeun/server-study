package com.example.springproject.controller;

import com.example.springproject.dto.request.RequestArticleDTO;
import com.example.springproject.dto.request.RequestMemberDTO;
import com.example.springproject.service.ArticleService;
import com.example.springproject.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;


    @PostMapping("/signup")
    public String save(@ModelAttribute RequestMemberDTO requestMemberDTO) {
        memberService.signup(requestMemberDTO);
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute RequestMemberDTO requestMemberDTO, HttpSession session) {
        RequestMemberDTO loginResult = memberService.login(requestMemberDTO);
        if (loginResult != null) {
            session.setAttribute("login_userid", loginResult.getUserid());
            return "main";
        } else {
            return "login";
        }
    }
}
