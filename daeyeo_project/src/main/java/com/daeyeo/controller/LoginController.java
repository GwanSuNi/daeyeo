package com.daeyeo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {
    @RequestMapping("")
    public String loginPage() {
        return "login/member_login";
    }

    @RequestMapping("/register")
    public String register() {return "login/member_register";}

    @RequestMapping("/findPw")
    public String findPw() {return "login/member_forgotPw";}
}
