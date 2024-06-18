package com.example.springproject.controller;

import com.example.springproject.dto.request.RequestArticleDTO;
import com.example.springproject.dto.response.ResponseArticleDTO;
import com.example.springproject.entity.ArticleEntity;
import com.example.springproject.repository.ArticleRepository;
import com.example.springproject.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.ui.Model;


@RestController
@RequestMapping("/article")
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    @PostMapping("/save")
    public String save(RequestArticleDTO requestarticleDTO, LocalDate createDate, @RequestHeader UUID userid) {
        articleService.save(requestarticleDTO, createDate, userid);
//        return "detail";
        return "redirect:/article";
    }

    @GetMapping("/delete/{id}")
    public String deleteById(RequestArticleDTO requestarticleDTO, UUID uuid) {
        articleService.deleteById(requestarticleDTO, uuid);
//        return "list";
        return "redirect:/article";
    }

    @GetMapping("/findAll")
    public String findAll(Model model) {
        List<ResponseArticleDTO> responseArticleDTOList = articleService.findAll();
        model.addAttribute("article_list", responseArticleDTOList);

        return "list";
    }

    @GetMapping("/findById/{id}")
    public String findById(@PathVariable UUID uuid, Model model) {
        ResponseArticleDTO responseArticleDTO = articleService.findById(uuid);
        model.addAttribute("article", responseArticleDTO);

        return "detail";
    }

    @PatchMapping("/update")
    public String update(@ModelAttribute RequestArticleDTO requestArticleDTO, UUID uuid, UUID userid, LocalDate createDate) {
        articleService.update(requestArticleDTO, uuid, userid, createDate);

        return "detail";
    }
}