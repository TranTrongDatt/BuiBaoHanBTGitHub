package com.example.BuiBaoHanBTDemo1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "BuiBaoHan Demo");
        model.addAttribute("message", "Chào mừng đến với Spring Boot!");
        return "index";
    }

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("title", "Giới thiệu");
        return "about";
    }
}
