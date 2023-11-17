package com.daeyeo.helloDaeyeo.controller.admincontroller;

import com.daeyeo.helloDaeyeo.dto.adminDto.*;
import com.daeyeo.helloDaeyeo.dto.memberDto.AdminMemberDto;
import com.daeyeo.helloDaeyeo.dto.memberDto.RentalForm;
import com.daeyeo.helloDaeyeo.embedded.Address;
import com.daeyeo.helloDaeyeo.entity.Member;
import com.daeyeo.helloDaeyeo.entity.Role;
import com.daeyeo.helloDaeyeo.service.*;
import com.daeyeo.helloDaeyeo.service.userDetails.UserService;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/adminpage")
@Secured("ROLE_ADMIN")
public class AdminController {
    private final MemberService memberService;
    private final UserService userService;
    private final PeriodTestService periodTestService;
    private final AdminService adminService;
    private final RentalObjectService rentalObjectService;
    private final RentalStatusService rentalStatusService;

    @GetMapping("/")
    public String mainPage(Model model, @CurrentSecurityContext(expression = "authentication") Authentication authentication) {
        model.addAttribute("name", authentication.getName());
        return "adminpage/adminMainPage";
    }

    @GetMapping("adminMember")
    public String memberPage(Model model, @CurrentSecurityContext(expression = "authentication") Authentication authentication) {
        model.addAttribute("name", authentication.getName());
        List<Member> memberList = memberService.findAllWithOutQuitedUser();
        List<AdminMemberDto> adminMemberDtos = memberService.adminMemberPage(memberList);
        model.addAttribute("adminMemberDtos", adminMemberDtos);
        // JSON 타입으로 전달하기 위한 속성
        List<String> adminMemberJsons = memberService.adminMemberPageJson(adminMemberDtos);
        model.addAttribute("adminMemberJsons", adminMemberJsons);
        // Role 종류 전달
        model.addAttribute("roles", Role.values());
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
        return "/adminpage/updateRolesForm";
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
    public ResponseEntity<String> updateRoles(@RequestBody @NotNull Map<String, Object> requestBody) {
        // JSON 데이터에서 roles 값을 가져와서 배열로 변환
        List<String> roles = (List<String>) requestBody.get("roles");
        String userEmail = requestBody.get("userEmail").toString();
        log.warn("{}", userEmail);
        // 열거형으로 변환
        Set<Role> roleSet = roles.stream()
                .map(Role::valueOf) // 열거형의 이름과 일치하는 문자열을 열거형으로 변환
                .collect(Collectors.toSet());

        Member member = userService.updateMemberRoles(userEmail, roleSet);
        if (member == null) {
            log.warn("Member가 null");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("권한 변경에 실패했습니다. 다시 확인해주세요.");
        }

        AdminMemberDto adminMemberDto = new AdminMemberDto(member);
        String resultMember = memberService.adminMemberDtoToJson(adminMemberDto);
        log.info("변경된 후: {}", resultMember);
        return new ResponseEntity<>(resultMember, HttpStatus.OK);
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

    /**
     * 회원이 대여한 내역을 조회하는 컨트롤러 메서드
     *
     * @param userEmail pathVariable로 받은 회원
     * @return 조회한 대여 내역과 상태 코드 200 ok를 반환. 조회된 내역이 없어도 빈 리스트 반환
     */
    @GetMapping("/memberRentals/{userEmail}")
    public ResponseEntity<List<MemberRentalsResponseDto>> getMemberRentals(@PathVariable String userEmail) {
        List<MemberRentalsResponseDto> responseDtos = adminService.findMemberRentals(userEmail);

        return ResponseEntity.ok(responseDtos);
    }

    /**
     * 회원이 등록한 대여 항목을 조회하는 컨트롤러 메서드
     *
     * @param userEmail pathVariable로 받은 회원
     * @return 조회한 대여 항목과 상태 코드 200 ok를 반환. 조회된 대여 항목이 없어도 빈 리스트 반환
     */
    @GetMapping("/memberRegistrations/{userEmail}")
    public ResponseEntity<List<MemberRegistrationsResponseDto>> getMemberRegistrations(@PathVariable String userEmail) {
        List<MemberRegistrationsResponseDto> responseDtos = adminService.findMemberRegistrations(userEmail);

        return ResponseEntity.ok(responseDtos);
    }

    /**
     * 모든 회원의 대여 게시글을 조회하여 모델에 추가하고 adminPostPage를 반환하는 메서드
     *
     * @param model 뷰에 데이터를 제공하는 Model 객체
     * @return adminPostPage 뷰
     */
    @GetMapping("/rentalWrites")
    public String AllMembersRentalWrites(Model model) {
        List<AllMembersRentalWritesResponseDto> responseDtos = adminService.findAllMembersRentalWrites();
        model.addAttribute("rentalWrites", responseDtos);

        return "adminpage/adminPostPage";
    }

    @GetMapping("/rentalWriteDetail/{objectIndex}")
    public ResponseEntity<RentalWriteDetailResponseDto> getRentalWriteDetail(@PathVariable Long objectIndex) {
        RentalWriteDetailResponseDto responseDto = adminService.getRentalWriteDetail(objectIndex);

        return ResponseEntity.ok(responseDto);
    }

    // 어드민이 유저를 탈퇴하는 메서드
    @PostMapping("/quitUser")
    public ResponseEntity<String> quitUser(@RequestBody QuitUserRequestDto request) {
        Member member = userService.findByUserEmail(request.getUserEmail());
//        TODO: 아래 진행상황에서 false가 발생했을 때 롤백 어떻게?
        String formattedUserEmail = userService.quitUser(request.getUserEmail());
        log.info("formattedUserEmail: {}", formattedUserEmail);
        boolean result = true;
        if (!member.getRentalObjects().isEmpty()) {
            result = rentalObjectService.updateQuitUserInfo(member.getId(), formattedUserEmail);
            log.info("ROResult: {}", result);
        }
        if (!member.getRentalStatuses().isEmpty()) {
            result = rentalStatusService.updateQuitUserInfo(member.getId(), formattedUserEmail);
            log.info("RsResult: {}", result);
        }
        if (result)
            return new ResponseEntity<>(HttpStatus.OK);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("탈퇴 요청이 실패했습니다. 다시 시도해 주세요.");
    }

    // 어드민이 임시 비밀번호를 부여하는 메서드
    @PostMapping("/tempPassword")
    public ResponseEntity<String> tempPwUser(@RequestBody TempPwDto request) {
        boolean result = userService.updateMemberPassword(request.getUserEmail(), request.getTempPw());
        if (result) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("임시 비밀번호 설정에 실패했습니다. 다시 시도해 주세요.");
        }
    }
}
