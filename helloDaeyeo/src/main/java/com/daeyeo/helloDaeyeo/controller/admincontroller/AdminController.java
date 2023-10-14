package com.daeyeo.helloDaeyeo.controller.admincontroller;

import com.daeyeo.helloDaeyeo.dto.memberDto.AdminMemberDto;
import com.daeyeo.helloDaeyeo.dto.memberDto.RentalForm;
import com.daeyeo.helloDaeyeo.embedded.Address;
import com.daeyeo.helloDaeyeo.entity.Member;
import com.daeyeo.helloDaeyeo.entity.PeriodTest;
import com.daeyeo.helloDaeyeo.repository.PeriodTestRepository;
import com.daeyeo.helloDaeyeo.service.MemberService;
import com.daeyeo.helloDaeyeo.service.PeriodTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequestMapping("/adminpage")
public class AdminController {
    @Autowired
    MemberService memberService;
    @Autowired
    PeriodTestService periodTestService;


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
    @PostMapping("cal")
    public String calpost(RentalForm rentalForm){
        // 매개변수로 선택된날짜랑 시작시간 끝나는시간 RentalStatus
        // 하나의 메서드에서 다 형변환을 시켜주고 RentalStatus 안에 집어넣을생각
        String dateString = rentalForm.getSelectedDate();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate selectedDate = LocalDate.parse(dateString, formatter);
        LocalDateTime startTime = rentalForm.castTime(rentalForm.getSelectedDate(),rentalForm.getStartTime());
        LocalDateTime endTime = rentalForm.castTime(rentalForm.getSelectedDate(),rentalForm.getEndTime());
        if(startTime.isBefore(endTime)){
            // 값 검증함
            if(periodTestService.validPeriod(startTime,endTime)){
                // 값넣기
                periodTestService.insertPeriod(startTime,endTime);
            }else{
                // 에러
                System.out.println("시간이겹친다!");
            }

        }else{
            // 에러
            System.out.println("시간이 앞선다!");
        }
        return "redirect:/cal";
    }
}
