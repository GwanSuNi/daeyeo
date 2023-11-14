package com.daeyeo.helloDaeyeo.controller.mypagecontroller;

import com.daeyeo.helloDaeyeo.dto.memberDto.MemberDeleteDto;
import com.daeyeo.helloDaeyeo.dto.memberDto.MemberManageDto;
import com.daeyeo.helloDaeyeo.dto.memberDto.MemberUpdateDto;
import com.daeyeo.helloDaeyeo.dto.memberDto.MemberUpdatePwDto;
import com.daeyeo.helloDaeyeo.dto.myPageDto.ModalStatusPendingDto;
import com.daeyeo.helloDaeyeo.dto.myPageDto.RentalObjectManageDto;
import com.daeyeo.helloDaeyeo.entity.Member;
import com.daeyeo.helloDaeyeo.entity.RentalObject;
import com.daeyeo.helloDaeyeo.entity.RentalStatus;
import com.daeyeo.helloDaeyeo.entity.WishList;
import com.daeyeo.helloDaeyeo.repository.MemberRepository;
import com.daeyeo.helloDaeyeo.service.*;
import com.daeyeo.helloDaeyeo.service.userDetails.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequiredArgsConstructor
@Slf4j
@Secured({"ROLE_ADMIN", "ROLE_OWNER", "ROLE_VIP_MEMBER", "ROLE_MEMBER"})
@RequestMapping("/myPage")
public class MyPageController {
    private final MemberRepository memberRepository;
    private final MemberService memberService;
    private final RentalObjectService rentalObjectService;
    private final RentalStatusService rentalStatusService;
    private final RentalLogService rentalLogService;
    private final WishListService wishListService;
    private final UserService userService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    /***
     * id 값만 받아오면
     * @return
     */
//    @RequestMapping("")
//    public String myPage(Model model){
//        String memberId = "test@test.com";
//        Member member = memberService.findMember(memberId).get();
//        model.addAttribute("member",member);
//        return "/myPage/myPage";
//    }

    /***
     * GetMapping 으로 값을 받아서
     * @param model
     * @return
     */
    // TODO: Member에 대해 null 검사
    @GetMapping("")
    public String myPageGetForm(Model model, @CurrentSecurityContext(expression = "authentication") Authentication authentication) {
        Member member = memberService.findMember(authentication.getName()).orElse(null);
        model.addAttribute("member", member);
        model.addAttribute("memberUpdatePw", new MemberUpdatePwDto());
        model.addAttribute("memberUpdateForm", new MemberUpdateDto());
        model.addAttribute("memberDelete", new MemberDeleteDto());
        return "/myPage/myPage";
    }

    @PostMapping("/updateInfo")
    public String myPageUpdateInfo(@Valid MemberUpdateDto memberUpdateDto, BindingResult bindingResult, Model model, @CurrentSecurityContext(expression = "authentication") Authentication authentication) {
        String memberEmail = authentication.getName();
        Member member = memberService.findMember(memberEmail).orElse(null);
        memberService.updateMember(memberEmail, memberUpdateDto);
        model.addAttribute("member", member);
        return "redirect:/myPage";
    }

    // TODO: 결과 속성 출력 안됨, 성공 시 alert()
    @PostMapping("/updatePw")
    public String myPageUpdatePw(@Valid MemberUpdatePwDto memberUpdatePwDto, BindingResult bindingResult, RedirectAttributes redirectAttributes, @CurrentSecurityContext(expression = "authentication") Authentication authentication) {
        String memberEmail = authentication.getName();
        Member member = userService.findByUserEmail(memberEmail); // 무조건 null이 아님
        if (bindingResult.hasErrors()) {
            log.warn("bindingResult에서 문제 발생");
            return "redirect:/myPage";
        }
        if (!userService.comparePassword(memberEmail, memberUpdatePwDto.getPw())) { // 원래 비밀번호와 맞지 않으면
            log.warn("비번 다름");
            redirectAttributes.addFlashAttribute("member", member);
            redirectAttributes.addFlashAttribute("notSamePw", "로그인한 유저의 패스워드와 일치하지 않습니다. 다시 입력해주세요.");
            return "redirect:/myPage";
        }
        if (bCryptPasswordEncoder.matches(memberUpdatePwDto.getNewPw(), member.getPassword())) {
            log.warn("기존 비번과 같음");
            redirectAttributes.addFlashAttribute("notSamePw", "새로운 비밀번호는 기존 비밀번호와 다르게 설정해주세요.");
            return "redirect:/myPage";
        }
        if (!memberUpdatePwDto.getNewPw().equals(memberUpdatePwDto.getNewPwRepeat())) { // 재확인 다르면
            log.warn("재확인 다름");
            redirectAttributes.addFlashAttribute("member", member);
            redirectAttributes.addFlashAttribute("notSamePwConfirm", "비밀번호가 일치하지 않습니다. 다시 입력해주세요.");
            return "redirect:/myPage";
        }
        // 모두 문제 없을 시
        // 비밀번호 변경
        userService.updateMemberPassword(memberEmail, memberUpdatePwDto.getNewPw());
        Member updatedMember = userService.findByUserEmail(memberEmail);
        log.warn("비번 바꾼 결과: {}", updatedMember);
        redirectAttributes.addFlashAttribute("member", updatedMember);
        redirectAttributes.addFlashAttribute("result", "비밀번호 변경 완료");
        return "redirect:/myPage";
    }

    @PostMapping("/delete")
    public String myPageDelete(@Valid MemberDeleteDto memberDeleteDto, BindingResult bindingResult, RedirectAttributes redirectAttributes, @CurrentSecurityContext(expression = "authentication") Authentication authentication) {
        String userEmail = authentication.getName();
        if (bindingResult.hasErrors()) {
            return "redirect:/myPage";
        }
        if (!userService.comparePassword(memberDeleteDto.getMemberId(), memberDeleteDto.getMemberPw())) { // 비밀번호가 맞는지 확인
            redirectAttributes.addFlashAttribute("idpwError", "아이디 혹은 비밀번호가 틀립니다.");
            return "redirect:/myPage";
        }
        userService.deleteMember(userEmail, memberDeleteDto);
        return "redirect:/memberApi/logout";
    }

    @RequestMapping("myWishList")
    public String wishList(Model model, @CurrentSecurityContext(expression = "authentication") Authentication authentication) {
        model.addAttribute("isLogined", !(authentication instanceof AnonymousAuthenticationToken));
        // 권한을 컬렉션에서 확인
        boolean isAdmin = authentication.getAuthorities().stream()
                .anyMatch(authority -> "ROLE_ADMIN".equals(authority.getAuthority()));
        model.addAttribute("isAdmin", isAdmin);
        log.info("principal : {}, name: {}, authorities: {}, details : {}", authentication.getPrincipal(), authentication.getName(), authentication.getAuthorities(), authentication.getDetails());

        String memberEmail = authentication.getName();
        List<WishList> wishList = wishListService.findAll(memberEmail);
        model.addAttribute("wishList", wishList);
        return "/myPage/myWishList";
    }

    @RequestMapping("reservation") // 예약기록 내가 곧 사용할 기록 대여시간이 현재시간보다 앞서있다
    // rentalStatus 의 endtime 이 현재시간보다 앞서있다 내가 곧 사용할 rentalObject 갖고옴
    public String reservation(Model model, @CurrentSecurityContext(expression = "authentication") Authentication authentication) {
        model.addAttribute("isLogined", !(authentication instanceof AnonymousAuthenticationToken));
        // 권한을 컬렉션에서 확인
        boolean isAdmin = authentication.getAuthorities().stream()
                .anyMatch(authority -> "ROLE_ADMIN".equals(authority.getAuthority()));
        model.addAttribute("isAdmin", isAdmin);
        log.info("principal : {}, name: {}, authorities: {}, details : {}", authentication.getPrincipal(), authentication.getName(), authentication.getAuthorities(), authentication.getDetails());

        String memberEmail = authentication.getName();
        Member member = memberService.findMember(memberEmail).get();
        List<RentalStatus> rentalStatuses = rentalStatusService.rentalStatusBefore(member);
        model.addAttribute("rentalStatuses", rentalStatuses);
        return "/myPage/reservation";
    }

    @RequestMapping("rentalLog")
    public String rentalLog(Model model, @CurrentSecurityContext(expression = "authentication") Authentication authentication) {
        String memberEmail = authentication.getName();
        Member member = memberService.findMember(memberEmail).get();
        try {
            List<RentalStatus> rentalStatuses = rentalStatusService.rentalStatusAfter(member);
            model.addAttribute("rentalStatuses", rentalStatuses);
        } catch (RuntimeException runtimeException) {
//             서버가 계산하는데 시간걸려서 오류나가지구
//             ConcurrentModificationException : null 이란 오류 발생
//             주로 컬렉션을 동시에 수정하려는 상황에서 발생한다 해당 부분을 확인하고 동시성 문제를 수정하자
//             스레드 간 동기화를 고려하거나 컬렉션 변경을 안전하게 수행해야 한다
            return "redirect:/myPage/rentalLog";
        }
        return "/myPage/rentalLog";
    }

    @RequestMapping("rentalManage") // 내가 빌려줄 대여에대해서 허가를 할지 안할지
    public String rentalManage(Model model, @CurrentSecurityContext(expression = "authentication") Authentication authentication) {
        model.addAttribute("isLogined", !(authentication instanceof AnonymousAuthenticationToken));
        // 권한을 컬렉션에서 확인
        boolean isAdmin = authentication.getAuthorities().stream()
                .anyMatch(authority -> "ROLE_ADMIN".equals(authority.getAuthority()));
        model.addAttribute("isAdmin", isAdmin);
        log.info("principal : {}, name: {}, authorities: {}, details : {}", authentication.getPrincipal(), authentication.getName(), authentication.getAuthorities(), authentication.getDetails());


        String memberEmail = authentication.getName();
        // 해당 유저가 올린 모든 게시물을 갖고옴
        List<RentalObject> rentalObjectList = rentalObjectService.findAllMyRental(memberEmail);
        // 유저가 올린 모든 게시물을 파악하기위한것
        List<RentalObjectManageDto> rentalObjectManageDtoList = rentalObjectService.rentalObjectManagePage(rentalObjectList);
        int sum = 0;
        // 회원수익 값 넣는것
        for (RentalObjectManageDto rentalObjectManageDto : rentalObjectManageDtoList) {
            sum += rentalObjectManageDto.getEarnedMoney();
            Member member = memberService.findMember(memberEmail).get();
            member.setMoneyEarned(sum);
            memberRepository.save(member);
        }
        // Status를 나눔 사용하기 전에 게시물 신청인지 , 아니면 사용후의 게시물 신청인지
        List<RentalStatus> rentalStatusListBefore = rentalStatusService.beforeUse(rentalObjectList);

        List<RentalStatus> rentalStatusListAfter = rentalStatusService.afterUse(rentalObjectList);

        List<RentalStatus> rentalStatusList = rentalStatusService.beforeUseModal(rentalObjectList);
        List<RentalStatus> result = rentalStatusService.rentalStatusPendingList(rentalStatusList);

        model.addAttribute("rentalObjectManageDtoList", rentalObjectManageDtoList);
        model.addAttribute("rentalStatusListBefore", rentalStatusListBefore);
        model.addAttribute("rentalStatusListAfter", rentalStatusListAfter);
        model.addAttribute("result", result);
        return "/myPage/rentalManage";
    }

    @PostMapping("rentalManage/{statusId}/cancel")
    public String statusCancel(@PathVariable("statusId") int statusId, @CurrentSecurityContext(expression = "authentication") Authentication authentication, Model model) {
        model.addAttribute("isLogined", !(authentication instanceof AnonymousAuthenticationToken));
        // 권한을 컬렉션에서 확인
        boolean isAdmin = authentication.getAuthorities().stream()
                .anyMatch(authority -> "ROLE_ADMIN".equals(authority.getAuthority()));
        model.addAttribute("isAdmin", isAdmin);
        log.info("principal : {}, name: {}, authorities: {}, details : {}", authentication.getPrincipal(), authentication.getName(), authentication.getAuthorities(), authentication.getDetails());

        rentalStatusService.cancelStatus(statusId);
        RentalStatus rentalStatus = rentalStatusService.findOne(statusId);
        rentalLogService.insertRentalLog(rentalStatus);
        return "redirect:/myPage/rentalManage";
    }

    @PostMapping("rentalManage/{statusId}/permit")
    public String statusPermit(@PathVariable("statusId") int statusId, @CurrentSecurityContext(expression = "authentication") Authentication authentication, Model model) {
        model.addAttribute("isLogined", !(authentication instanceof AnonymousAuthenticationToken));
        // 권한을 컬렉션에서 확인
        boolean isAdmin = authentication.getAuthorities().stream()
                .anyMatch(authority -> "ROLE_ADMIN".equals(authority.getAuthority()));
        model.addAttribute("isAdmin", isAdmin);
        log.info("principal : {}, name: {}, authorities: {}, details : {}", authentication.getPrincipal(), authentication.getName(), authentication.getAuthorities(), authentication.getDetails());

        rentalStatusService.permitStatus(statusId);
        RentalStatus rentalStatus = rentalStatusService.findOne(statusId);
        rentalLogService.insertRentalLog(rentalStatus);
        return "redirect:/myPage/rentalManage";
    }

    /***
     * 끝난 시간이 현재 시간보다 과거일경우 RentalStatus 기록을 남게 함
     * 내가 대여한 목록
     * @return
     */

    @RequestMapping("memberManage")
    public String memberManage(@CurrentSecurityContext(expression = "authentication") Authentication authentication, Model model) {
        model.addAttribute("isLogined", !(authentication instanceof AnonymousAuthenticationToken));
        // 권한을 컬렉션에서 확인
        boolean isAdmin = authentication.getAuthorities().stream()
                .anyMatch(authority -> "ROLE_ADMIN".equals(authority.getAuthority()));
        model.addAttribute("isAdmin", isAdmin);
        log.info("principal : {}, name: {}, authorities: {}, details : {}", authentication.getPrincipal(), authentication.getName(), authentication.getAuthorities(), authentication.getDetails());
        String memberEmail = authentication.getName();
        List<RentalObject> rentalObjectList = rentalObjectService.findAllMyRental(memberEmail);
        List<Member> memberList = new ArrayList<>();
        List<String> memberIdList = new ArrayList<>();
        for (RentalObject rentalObject : rentalObjectList) {
            for (RentalStatus rentalStatus : rentalObject.getRentalStatuses()) {
                memberIdList.add(rentalStatus.getMember().getUserEmail());
            }
        }
//        List<String> memberIdList = new ArrayList<>();
//        id 에 추가된 갯수가 사용횟수 memberList 뒤져서 예약횟수 넣음
        Set<String> memberIdSet = new HashSet<>(memberIdList);

        for (String memberId : memberIdSet) {
            Member member = memberService.findMember(memberId).get();
            memberList.add(member);
        }

        List<MemberManageDto> memberManageDtoList = memberService.memberManageList(memberList, rentalObjectList);
        model.addAttribute("memberManageDtoList", memberManageDtoList);

        return "/myPage/memberManage";
    }

    @GetMapping("getModalRentalStatusList")
    @ResponseBody
    public List<ModalStatusPendingDto> getPendingRentalStatusList(@CurrentSecurityContext(expression = "authentication") Authentication authentication, Model model) {
        model.addAttribute("isLogined", !(authentication instanceof AnonymousAuthenticationToken));
        // 권한을 컬렉션에서 확인
        boolean isAdmin = authentication.getAuthorities().stream()
                .anyMatch(authority -> "ROLE_ADMIN".equals(authority.getAuthority()));
        model.addAttribute("isAdmin", isAdmin);
        log.info("principal : {}, name: {}, authorities: {}, details : {}", authentication.getPrincipal(), authentication.getName(), authentication.getAuthorities(), authentication.getDetails());

        String memberEmail = authentication.getName();
        List<RentalObject> rentalObjectList = rentalObjectService.findAllMyRental(memberEmail);
        List<RentalStatus> rentalStatusList = rentalStatusService.beforeUseModal(rentalObjectList);
        List<RentalStatus> rentalStatusList1 = rentalStatusService.rentalStatusPendingList(rentalStatusList);
        List<ModalStatusPendingDto> result = rentalStatusService.modalStatusPending(rentalStatusList1);
        return result;
    }

    @GetMapping("ModalRentalStatus/{objectIndex}")
    @ResponseBody
    public List<ModalStatusPendingDto> getRentalStatusList(@PathVariable("objectIndex") long objectIndex,
                                                           @CurrentSecurityContext(expression = "authentication")
                                                           Authentication authentication, Model model) {
        model.addAttribute("isLogined", !(authentication instanceof AnonymousAuthenticationToken));
        // 권한을 컬렉션에서 확인
        boolean isAdmin = authentication.getAuthorities().stream()
                .anyMatch(authority -> "ROLE_ADMIN".equals(authority.getAuthority()));
        model.addAttribute("isAdmin", isAdmin);
        log.info("principal : {}, name: {}, authorities: {}, details : {}", authentication.getPrincipal(), authentication.getName(), authentication.getAuthorities(), authentication.getDetails());

        // 일단 리스트만 내보냄

        RentalObject rentalObject = rentalObjectService.getOneRentalObject(objectIndex);
        List<RentalStatus> rentalStatusList = rentalObject.getRentalStatuses();
//        for (RentalStatus rentalStatus : rentalObject.getRentalStatuses()) {
//            if (LocalDateTime.now().isAfter(rentalStatus.getEndTime())) {
//                rentalStatusList.add(rentalStatus);
//            }
//        }
        List<ModalStatusPendingDto> result = rentalStatusService.modalStatusPending(rentalStatusList);

        return result;
    }
}
