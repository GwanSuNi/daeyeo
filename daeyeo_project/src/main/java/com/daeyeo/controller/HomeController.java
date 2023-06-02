package com.daeyeo.controller;

import com.daeyeo.entity.UserEntity;
import com.daeyeo.service.NewUserService;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @Autowired
    NewUserService userService;
    @RequestMapping("/")
    public String home() {
        return "mainPage";
    }

    @RequestMapping("/test")
    public String test(Model model) {
        UserEntity user = userService.findUserByEmail("test@test.com");
        model.addAttribute("user", user);
        return "test";
    }

    @GetMapping("/error/{statusCode}")
    public String getErrorPage(@PathVariable String statusCode) {
        return "error/" + statusCode;
    }

    @GetMapping("/guidebook")
    public String guidebook() {
        return "guidebook";
    }
}
