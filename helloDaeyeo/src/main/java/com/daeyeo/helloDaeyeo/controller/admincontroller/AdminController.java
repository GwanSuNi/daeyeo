package com.daeyeo.helloDaeyeo.controller.admincontroller;

import com.daeyeo.helloDaeyeo.dto.memberDto.AdminMemberDto;
import com.daeyeo.helloDaeyeo.embedded.Address;
import com.daeyeo.helloDaeyeo.entity.Member;
import com.daeyeo.helloDaeyeo.entity.Role;
import com.daeyeo.helloDaeyeo.service.MemberService;
import com.daeyeo.helloDaeyeo.service.userDetails.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Controller
@RequiredArgsConstructor
@RequestMapping("/adminpage")
@Secured("ROLE_ADMIN")
public class AdminController {
    private final MemberService memberService;
    private final UserService userService;

    @RequestMapping("/")
    public String mainPage(Model model, @CurrentSecurityContext(expression = "authentication") Authentication authentication) {
        model.addAttribute("name", authentication.getName());
        return "adminpage/adminMainPage";
    }

    @RequestMapping("adminMember")
    public String memberPage(Model model, @CurrentSecurityContext(expression = "authentication") Authentication authentication) {
        model.addAttribute("name", authentication.getName());
        List<Member> memberList = memberService.findAll();
        List<AdminMemberDto> adminMemberDtos = memberService.adminMemberPage(memberList);
        model.addAttribute("adminMemberDtos", adminMemberDtos);
        return "adminpage/adminMemberPage";
    }

    @RequestMapping("adminReview")
    public String reviewPage(Model model) {
        return "adminpage/adminReviewPage";
    }

    @RequestMapping("adminPost")
    public String postPage(Model model) {
        return "adminpage/adminPostPage";
    }

    @RequestMapping("adminStatistics")
    public String statisticsPage(Model model) {
        return "adminpage/adminStatisticsPage";
    }

    @RequestMapping("adminAd")
    public String adPage(Model model) {
        return "adminpage/adminAdPage";
    }

    @RequestMapping("adminAdForm")
    public String adFormPage(Model model) {
        return "adminpage/adminAdFormPage";
    }

    @GetMapping("mapex")
    public String mapex(Model model) {
        Address address = new Address();
        address.setAddress("서울 노원구 동일로237바길");
        address.setDetailAddress("101동802호");
        address.setExtraAddress("(상계동, 북부현대아파트)");
        address.setPostcode("01610");
        model.addAttribute("address", address);
        return "rental/mapex";
    }

    // 사용자의 역할 조회
    @GetMapping("/updateRoles/{userEmail}")
    public String showUpdateRolesForm(@PathVariable String userEmail, Model model) {
        // 사용자의 현재 역할을 불러와 모델에 추가
        Member member = userService.findByUserEmail(userEmail);
        Set<Role> currentRoles = member.getRoles();
        model.addAttribute("userEmail", userEmail);
        model.addAttribute("currentRoles", currentRoles);
        // TODO: 어디에 보여줄거?
        return "/admin/updateRolesForm";
    }

    // 어드민이 유저의 권한을 변경하는 메서드
    @PostMapping("/updateRoles")
    public String updateRoles(@RequestParam String userEmail, @RequestParam Set<Role> roles) {
        userService.updateMemberRoles(userEmail, roles);
        return "redirect:/adminMember"; // 사용자 목록 페이지로 리다이렉트
    }

}
