package com.example.springproject.controller;

import jakarta.persistence.Id;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/article")
public class HomeController {

    @GetMapping("/")
    public String main() {
        return "start";
    }

}
