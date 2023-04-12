package com.spring.ex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String home() {
        return "index";
    }
    
    @RequestMapping("/tecte")
    public String tecte() {
        return "tecteTest";
    }
    
    @RequestMapping("/gwan")
    public String gwan() {
        return "gwan";
    }
    @RequestMapping("/intae")
    public String intae(){
        return "intae";
    }
    @RequestMapping("/sanghyeon")
    public String sanghyeon(){
        return "sanghyeon";
    }

}
