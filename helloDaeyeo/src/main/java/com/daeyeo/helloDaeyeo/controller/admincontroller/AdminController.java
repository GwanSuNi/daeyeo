package com.daeyeo.helloDaeyeo.controller.admincontroller;

import com.daeyeo.helloDaeyeo.dto.memberDto.AdminMemberDto;
import com.daeyeo.helloDaeyeo.entity.Member;
import com.daeyeo.helloDaeyeo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/adminpage")
public class AdminController {
    @Autowired
    MemberService memberService;

    @RequestMapping("adminMain")
    public String mainPage(Model model){
        return "adminpage/adminMainPage";
    }
    @RequestMapping ("adminMember")
    public String memberPage(Model model){
        List<Member> memberList = memberService.findAll();
        List<AdminMemberDto> adminMemberDtos = memberService.adminMemberPage(memberList);
        model.addAttribute("adminMemberDtos",adminMemberDtos);
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
