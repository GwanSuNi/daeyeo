package com.daeyeo.helloDaeyeo.controller.mypagecontroller;

import com.daeyeo.helloDaeyeo.dto.memberDto.MemberDeleteDto;
import com.daeyeo.helloDaeyeo.dto.memberDto.MemberUpdateDto;
import com.daeyeo.helloDaeyeo.dto.memberDto.MemberUpdatePwDto;
import com.daeyeo.helloDaeyeo.dto.myPageDto.RentalObjectManageDto;
import com.daeyeo.helloDaeyeo.entity.Member;
import com.daeyeo.helloDaeyeo.entity.RentalObject;
import com.daeyeo.helloDaeyeo.entity.RentalStatus;
import com.daeyeo.helloDaeyeo.service.MemberService;
import com.daeyeo.helloDaeyeo.service.RentalObjectService;
import com.daeyeo.helloDaeyeo.service.RentalStatusService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
@Secured({"ROLE_MEMBER", "ROLE_ADMIN"})
@RequestMapping("/myPage")
public class MyPageController {
    private final MemberService memberService;
    private final RentalObjectService rentalObjectService;
    private final RentalStatusService rentalStatusService;


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
        log.info("인증 정보 {}", authentication.getName());
        // TODO: 코드 중복
        model.addAttribute("isLogined", !(authentication instanceof AnonymousAuthenticationToken));
        // 권한을 컬렉션에서 확인
        boolean isAdmin = authentication.getAuthorities().stream()
                .anyMatch(authority -> "ROLE_ADMIN".equals(authority.getAuthority()));
        model.addAttribute("isAdmin", isAdmin);

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

    // TODO: Gwan이 할게
    @PostMapping("/updatePw")
    public String myPageUpdatePw(@Valid MemberUpdatePwDto memberUpdatePwDto, BindingResult bindingResult,
                                 Model model, RedirectAttributes redirectAttributes, @CurrentSecurityContext(expression = "authentication") Authentication authentication) {
        String memberEmail = authentication.getName();
        Member member = memberService.findMember(memberEmail).orElse(null);
        if (!member.getUserPw().equals(memberUpdatePwDto.getPw())) {
            redirectAttributes.addFlashAttribute("member", member);
            redirectAttributes.addFlashAttribute("notSamePw", "로그인한 유저의 패스워드와 일치하지 않습니다 다시 입력해주세요");
            return "redirect:/myPage";
        } else if (!memberUpdatePwDto.getNewPw1().equals(memberUpdatePwDto.getNewPw())) {
            redirectAttributes.addFlashAttribute("member", member);
            redirectAttributes.addFlashAttribute("notSamePwConfirm", "비밀번호 확인이 둘다 다릅니다. 다시 입력해주세요");
            return "redirect:/myPage";
        } else {
            memberService.updateMemberPw(memberEmail, memberUpdatePwDto);
            model.addAttribute("member", member);
            return "redirect:/myPage";
        }
    }

    // TODO: 얘도 시큐리티로 해야함
    @PostMapping("/delete")
    public String myPageDelete(@Valid MemberDeleteDto memberDeleteDto, BindingResult bindingResult,
                               Model model, @CurrentSecurityContext(expression = "authentication") Authentication authentication) {
        String memberEmail = authentication.getName();
        Member member = memberService.findMember(memberEmail).orElse(null);
        if (member.getUserPw().equals(memberDeleteDto.getMemberPw()) &&
                memberEmail.equals(memberDeleteDto.getMemberId())) {
            memberService.deleteMember(memberEmail, memberDeleteDto);
            return "redirect:/myPage"; // 로그아웃되는 로직을 짜야함
        } else if (bindingResult.hasErrors()) {
            return "/myPage/myPage";
        } else {
            model.addAttribute("idpwError", "아이디 혹은 비밀번호가 틀립니다.");
            return "redirect:/myPage";
        }
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
//        List<Review> reviewList = memberService.reviewList(memberEmail);
//        model.addAttribute("reviewList", reviewList);
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
        List<RentalStatus> rentalStatuses = rentalStatusService.rentalStatusAfter(member);
        model.addAttribute("rentalStatuses", rentalStatuses);
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
        List<RentalObject> rentalObjectList = rentalObjectService.findAllMyRental(memberEmail);
        List<RentalObjectManageDto> rentalObjectManageDtoList = rentalObjectService.rentalObjectManagePage(rentalObjectList);
        // Status 를 걸러야 하는
        List<RentalStatus> rentalStatusListBefore = rentalStatusService.beforeUse(rentalObjectList);
        List<RentalStatus> rentalStatusListAfter = rentalStatusService.afterUse(rentalObjectList);
        model.addAttribute("rentalObjectManageDtoList", rentalObjectManageDtoList);
        model.addAttribute("rentalStatusListBefore", rentalStatusListBefore);
        model.addAttribute("rentalStatusListAfter", rentalStatusListAfter);
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
        return "redirect:/myPage/rentalManage";
    }

    /***
     * 끝난 시간이 현재 시간보다 과거일경우 RentalStatus 기록을 남게 함
     * 내가 대여한 목록
     * @return
     */

    @RequestMapping("memberManage")
    public String memberManage() {
        return "/myPage/memberManage";
    }

}
