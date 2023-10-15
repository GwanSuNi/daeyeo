package com.daeyeo.helloDaeyeo.controller.userView;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserViewController {
    @GetMapping("/login")
    public String login() {
        return "login/memberLogin";
    }
//
//    @GetMapping("/signup")
//    public String signup() {
//        return "login/memberRegister";
//    }

    @GetMapping("/")
    public String mainPage() {
        return "/mainPage";
    }
}
