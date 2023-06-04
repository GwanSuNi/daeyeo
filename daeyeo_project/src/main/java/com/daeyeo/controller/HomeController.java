package com.daeyeo.controller;

import com.daeyeo.entity.UserEntity;
import com.daeyeo.service.NewUserService;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @Autowired
    private NewUserService uService;
    @RequestMapping("/")
    public String home() {
        return "mainPage";
    }

    @RequestMapping("/test")
    public String test(Model model) {
        UserEntity user = uService.findUserByEmail("test@test.com");
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
    @GetMapping("/403")
    public String accessDenied(Authentication auth, Model model) {
        //Authentication타입의 파라미터를 받도록 설계해서 필요한 경우 사용자의 정보를 확인할 수 있도록 함
        System.out.println("access Denied : "+auth);
        System.out.println("403 실행됨");
        model.addAttribute("msg","접근이 제한된 화면입니다");
        return "error/403";
    }
}
