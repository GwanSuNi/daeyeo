package com.daeyeo.helloDaeyeo.controller.admincontroller;

import com.daeyeo.helloDaeyeo.dto.memberDto.AdminMemberDto;
import com.daeyeo.helloDaeyeo.dto.memberDto.RentalForm;
import com.daeyeo.helloDaeyeo.embedded.Address;
import com.daeyeo.helloDaeyeo.entity.Member;
import com.daeyeo.helloDaeyeo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping("mapex")
    public String mapex(Model model){
        Address address = new Address();
        address.setAddress("서울 노원구 동일로237바길");
        address.setDetailAddress("101동802호");
        address.setExtraAddress("(상계동, 북부현대아파트)");
        address.setPostcode("01610");
        model.addAttribute("address",address);
        return "rental/mapex";
    }
    @GetMapping("cal")
    public String calex(Model model){
        model.addAttribute("rentalForm",new RentalForm());
        return "rental/calendarEx";
    }
//    @PostMapping("cal")
//    public String calpost(RentalForm rentalForm){

//        rentalForm.getSelectedDate();

//    }
}
