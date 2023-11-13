package com.daeyeo.helloDaeyeo.controller.mypagecontroller;

import com.daeyeo.helloDaeyeo.dto.memberDto.MemberDeleteDto;
import com.daeyeo.helloDaeyeo.dto.memberDto.MemberUpdateDto;
import com.daeyeo.helloDaeyeo.dto.memberDto.MemberUpdatePwDto;
import com.daeyeo.helloDaeyeo.entity.Member;
import com.daeyeo.helloDaeyeo.service.MemberService;
import com.daeyeo.helloDaeyeo.service.userDetails.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
@Slf4j
@Secured({"ROLE_ADMIN", "ROLE_OWNER", "ROLE_VIP_MEMBER", "ROLE_MEMBER"})
@RequestMapping("/myPage")
public class MyPageController {
    private final MemberService memberService;
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
//        "redirect:/login/memberRegister"
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
            redirectAttributes.addFlashAttribute("notSamePw", "로그인한 유저의 패스워드와 일치하지 않습니다. 다시 입력해주세요");
            return "redirect:/myPage";
        }
        if (bCryptPasswordEncoder.matches(memberUpdatePwDto.getNewPw(), member.getPassword())) {
            log.warn("기존 비번과 같음");
            redirectAttributes.addFlashAttribute("notSamePw", "새로운 비밀번호는 기존 비밀번호와 다르게 설정해주세요");
            return "redirect:/myPage";
        }
        if (!memberUpdatePwDto.getNewPw().equals(memberUpdatePwDto.getNewPwRepeat())) { // 재확인 다르면
            log.warn("재확인 다름");
            redirectAttributes.addFlashAttribute("member", member);
            redirectAttributes.addFlashAttribute("notSamePwConfirm", "비밀번호가 일치하지 않습니다. 다시 입력해주세요");
            return "redirect:/myPage";
        }
        // 모두 문제 없을 시
        // 비밀번호 변경
        Member updatedMember = userService.updateMemberPassword(memberEmail, memberUpdatePwDto.getNewPw());
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
        String memberEmail = authentication.getName();
//        List<Review> reviewList = memberService.reviewList(memberEmail);
//        model.addAttribute("reviewList", reviewList);
        return "/myPage/myWishList";
    }

    @RequestMapping("reservation")
    public String reservation() {
        return "/myPage/reservation";
    }

    @RequestMapping("rentalManage")
    public String rentalManage() {
        return "/myPage/rentalManage";
    }

    @RequestMapping("rentalLog")
    public String rentalLog() {
        return "/myPage/rentalLog";
    }

    @RequestMapping("memberManage")
    public String memberManage() {
        return "/myPage/memberManage";
    }

}
