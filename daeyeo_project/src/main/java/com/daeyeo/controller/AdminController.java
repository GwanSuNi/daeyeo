package com.daeyeo.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {
    @RequestMapping("/adminmainpage")
    public String adminmainpage() {
        return "adminpage/adminmainpage";
    }
}
