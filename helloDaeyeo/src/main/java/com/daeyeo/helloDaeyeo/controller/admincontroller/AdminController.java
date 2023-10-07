package com.daeyeo.helloDaeyeo.controller.admincontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/adminpage")
public class AdminController {
    @RequestMapping("adminMain")
    public String mainPage(Model model){
        return "adminpage/adminMainPage";
    }
    @RequestMapping("adminMember")
    public String memberPage(Model model){
        return "adminpage/adminMemberPage";
    }
    @RequestMapping("adminReview")
    public String reviewPage(Model model){
        return "adminpage/adminReviewPage";
    }
    @RequestMapping("adminPost")
    public String postPage(Model model){
        return "adminpage/adminPostPage";
    }
    @RequestMapping("adminStatistics")
    public String statisticsPage(Model model){
        return "adminpage/adminStatisticsPage";
    }
    @RequestMapping("adminAd")
    public String adPage(Model model){
        return "adminpage/adminAdPage";
    }
    @RequestMapping("adminAdForm")
    public String adFormPage(Model model){
        return "adminpage/adminAdFormPage";
    }

}
