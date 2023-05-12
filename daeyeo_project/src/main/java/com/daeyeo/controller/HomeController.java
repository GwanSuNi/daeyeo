package com.daeyeo.controller;

import org.springframework.stereotype.Controller;
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

    @RequestMapping("/login")
    public String loginPage() {
        return "login/member_login";
    }

    @RequestMapping("/myPage")
    public String myPage() {
        return "myPage/myPage";
    }

    @RequestMapping("/passwordChange")
    public String passwordChange() {
        return "myPage/passwordChange";
    }

    @RequestMapping("/profile")
    public String profile() {
        return "myPage/profile";
    }

    @RequestMapping("/guidebook")
    public String guidebook() {
        return "guidebook";
    }
}
