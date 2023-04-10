package com.spring.ex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String home() {
        return "index";
    }
    @RequestMapping("/gwan")
    public String gwan() {
        return "gwan";
    }
}
