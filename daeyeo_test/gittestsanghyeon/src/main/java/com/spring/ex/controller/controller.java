package com.spring.ex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class controller {
    @RequestMapping("/")
    public String mapping(){
        return "index";
    }
    @RequestMapping("/sanghyeon")
    public String seosanghyeon(){

        return "sanghyeon";
    }
}
