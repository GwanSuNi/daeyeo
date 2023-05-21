package com.daeyeo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String home() {
        return "mainPage";
    }

    @RequestMapping("/test")
    public String test() {
        return "test";
    }

    @GetMapping("/error/{statusCode}")
    public String getErrorPage(@PathVariable String statusCode) {
        return "error/" + statusCode;
    }

}
