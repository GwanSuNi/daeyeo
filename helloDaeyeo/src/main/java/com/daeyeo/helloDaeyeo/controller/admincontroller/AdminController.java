package com.daeyeo.helloDaeyeo.controller.admincontroller;

import com.daeyeo.helloDaeyeo.dto.adminDto.SuspendRequestDto;
import com.daeyeo.helloDaeyeo.dto.memberDto.AdminMemberDto;
import com.daeyeo.helloDaeyeo.dto.memberDto.RentalForm;
import com.daeyeo.helloDaeyeo.embedded.Address;
import com.daeyeo.helloDaeyeo.entity.Member;
import com.daeyeo.helloDaeyeo.entity.Role;
import com.daeyeo.helloDaeyeo.service.MemberService;
import com.daeyeo.helloDaeyeo.service.PeriodTestService;
import com.daeyeo.helloDaeyeo.service.userDetails.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;

@Controller
@RequiredArgsConstructor
@RequestMapping("/adminpage")
@Secured("ROLE_ADMIN")
public class AdminController {
    private final MemberService memberService;
    private final UserService userService;
    private final PeriodTestService periodTestService;

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
        // JSON 타입으로 전달하기 위한 속성
        List<String> adminMemberJsons = memberService.adminMemberPageJson(adminMemberDtos);
        model.addAttribute("adminMemberJsons", adminMemberJsons);
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

    @PostMapping("cal")
    public String calpost(RentalForm rentalForm) {
        // 매개변수로 선택된날짜랑 시작시간 끝나는시간 RentalStatus
        // 하나의 메서드에서 다 형변환을 시켜주고 RentalStatus 안에 집어넣을생각
        String dateString = rentalForm.getSelectedDate();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDate selectedDate = LocalDate.parse(dateString, formatter);
        LocalDateTime startTime = rentalForm.castTime(rentalForm.getSelectedDate(), rentalForm.getStartTime());
        LocalDateTime endTime = rentalForm.castTime(rentalForm.getSelectedDate(), rentalForm.getEndTime());
        if (startTime.isBefore(endTime)) {
            // 값 검증함
            if (periodTestService.validPeriod(startTime, endTime)) {
                // 값넣기
                periodTestService.insertPeriod(startTime, endTime);
            } else {
                // 에러
                System.out.println("시간이겹친다!");
            }
        }
        return "test";
    }

    // 어드민이 유저의 권한을 변경하는 메서드
    @PostMapping("/updateRoles")
    public String updateRoles(@RequestParam String userEmail, @RequestParam Set<Role> roles) {
        userService.updateMemberRoles(userEmail, roles);
        return "redirect:/adminMember"; // 사용자 목록 페이지로 리다이렉트
    }

    // 어드민이 유저의 밴 기간을 변경하는 메서드
    @PostMapping("/suspendUser")
    public ResponseEntity<String> suspendUser(@RequestBody SuspendRequestDto request) {
        boolean result = memberService.suspendUser(request);

        // 변경 후 결과값
        AdminMemberDto memberDto = new AdminMemberDto(userService.findByUserEmail(request.getEmail()));
        String jsonData = memberService.adminMemberDtoToJson(memberDto);

        if (result) {
            return new ResponseEntity<>(jsonData, HttpStatus.OK);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("정지 변경에 실패했습니다. 다시 시도해 주세요.");
        }
    }

}
