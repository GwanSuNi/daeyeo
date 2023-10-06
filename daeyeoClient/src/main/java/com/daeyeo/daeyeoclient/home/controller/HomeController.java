package com.daeyeo.daeyeoclient.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping()
    public String mainPage() {
        return "mainPage";
    }

    @GetMapping("header")
    public String header() {
        return "includes/header";
    }
}
